package com.example.service;

import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.SubscriptionPlan;
import com.example.repository.InvoiceRepository;
import com.example.repository.SubscriptionPlanRepository;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;


@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private SubscriptionPlanRepository subscriptionPlanRepository;

    public byte[] generateInvoice(long subscriptionId) {
        Optional<SubscriptionPlan> subOptional = subscriptionPlanRepository.findById(subscriptionId);
        if (subOptional.isEmpty()) {
            throw new RuntimeException("Subscription Plan not found");
        }
        SubscriptionPlan sub = subOptional.get();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            Document document = new Document();
            PdfWriter.getInstance(document, baos);
            
            document.open();
            
            Font titleFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD, 20);
            document.add(new Paragraph("Zidio Connection Invoice", titleFont));
            
            String invoiceNumber = "INV-" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();

            document.add(new Paragraph(" ")); // Adding a blank line
            document.add(new Paragraph("Invoice Number: " + invoiceNumber));
            document.add(new Paragraph("Issued Date: " + LocalDate.now().toString()));
            document.add(new Paragraph("Plan: " + sub.getPlanName()));
            document.add(new Paragraph("Amount: $" + String.format("%.2f", sub.getPrice())));
            
            document.close();

            return baos.toByteArray();

        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error generating PDF invoice", e);
        }
    }
}

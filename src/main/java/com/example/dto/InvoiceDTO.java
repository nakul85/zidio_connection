package com.example.dto;

import java.time.LocalDate;

public class InvoiceDTO {

    private Long id;
    private String invoiceNumber;
    private LocalDate issuedDate;
    private Double amount;
    private Long userId;
    private String userName;

    public InvoiceDTO() {
    }

    public InvoiceDTO(Long id, String invoiceNumber, LocalDate issuedDate, Double amount, Long userId, String userName) {
        this.id = id;
        this.invoiceNumber = invoiceNumber;
        this.issuedDate = issuedDate;
        this.amount = amount;
        this.userId = userId;
        this.userName = userName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    public LocalDate getIssuedDate() {
        return issuedDate;
    }

    public void setIssuedDate(LocalDate issuedDate) {
        this.issuedDate = issuedDate;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
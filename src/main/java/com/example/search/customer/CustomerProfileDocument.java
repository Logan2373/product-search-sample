package com.example.search.customer;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "customer-profile")
public class CustomerProfileDocument {

    @Id
    private String customerId;

    private String customerName;

    private String mobile;

    private String email;

    private List<AccountDocument> accounts;

    private List<CardDocument> cards;

    public CustomerProfileDocument() {
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AccountDocument> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<AccountDocument> accounts) {
        this.accounts = accounts;
    }

    public List<CardDocument> getCards() {
        return cards;
    }

    public void setCards(List<CardDocument> cards) {
        this.cards = cards;
    }
}
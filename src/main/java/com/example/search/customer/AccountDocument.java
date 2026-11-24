package com.example.search.customer;

public class AccountDocument {

    private String accountNo;
    private String accountType;
    private Double balance;

    public AccountDocument() {
    }

    public AccountDocument(
            String accountNo,
            String accountType,
            Double balance) {

        this.accountNo = accountNo;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
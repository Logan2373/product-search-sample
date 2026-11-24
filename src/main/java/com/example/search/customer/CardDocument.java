package com.example.search.customer;

public class CardDocument {

    private String cardNo;
    private String cardType;
    private String status;

    public CardDocument() {
    }

    public CardDocument(
            String cardNo,
            String cardType,
            String status) {

        this.cardNo = cardNo;
        this.cardType = cardType;
        this.status = status;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
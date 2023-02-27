package com.flightticketbooking.dto;

public class Payment {
    private String cardNumber;
    private String cardType;
    private String expirationDate;

    public Payment() {
    }

    public Payment(String cardNumber, String cardType, String expirationDate) {
        this.cardNumber = cardNumber;
        this.cardType = cardType;
        this.expirationDate = expirationDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "cardNumber='" + cardNumber + '\'' +
                ", cardType='" + cardType + '\'' +
                ", expirationDate='" + expirationDate + '\'' +
                '}';
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }
}

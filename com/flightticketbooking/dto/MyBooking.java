package com.flightticketbooking.dto;

import java.util.List;

public class MyBooking {
    private static int bookingCount=1;
    private int bookingId;
    private String flightNumber;
    private String airline;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String classType;
    private float totalPrice;
    private List<Passenger> passengers;
    private Payment payment;
    public MyBooking() {
    }

    public MyBooking(String flightNumber, String airline, Airport departure, Airport arrival, String classType, float totalPrice, List<Passenger> passengerList) {
        this.bookingId = bookingCount++;
        this.flightNumber = flightNumber;
        this.airline = airline;
        this.departureAirport = departure;
        this.arrivalAirport = arrival;
        this.classType = classType;
        this.totalPrice = totalPrice;
        this.passengers = passengerList;
    }
    public static int getBookingCount() {
        return bookingCount;
    }

    public static void setBookingCount(int bookingCount) {
        MyBooking.bookingCount = bookingCount;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flightNumber='" + flightNumber + '\'' +
                ", airline='" + airline + '\'' +
                ", departureAirport=" + departureAirport +
                ", arrivalAirport=" + arrivalAirport +
                ", classType='" + classType + '\'' +
                ", totalPrice=" + totalPrice +
                ", passengers=" + passengers +
                ", payment=" + payment +
                '}';
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public Airport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(Airport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public Airport getArrivalAirport() {
        return arrivalAirport;
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getClassType() {
        return classType;
    }

    public void setClassType(String classType) {
        this.classType = classType;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(List<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }
}

package com.flightticketbooking.dto;

public class Flight {
    private String airline;
    private String flightNumber;
    private Airport departureAirport;
    private Airport arrivalAirport;
    private String duration;
    private String price;
    private int firstClassCapacity;
    private int businessClassCapacity;
    private int economyClassCapacity;
    private int firstClassAvailable;
    private int businessClassAvailable;
    private int economyClassAvailable;
    public Flight(){}

    public Flight(String airline, String flightNumber, Airport departureAirport, Airport arrivalAirport, String duration, String price, int firstClassCapacity, int businessClassCapacity, int economyClassCapacity) {
        this.airline = airline;
        this.flightNumber = flightNumber;
        this.departureAirport = departureAirport;
        this.arrivalAirport = arrivalAirport;
        this.duration = duration;
        this.price = price;
        this.firstClassCapacity = firstClassCapacity;
        this.businessClassCapacity = businessClassCapacity;
        this.economyClassCapacity = economyClassCapacity;
        this.firstClassAvailable=firstClassCapacity;
        this.businessClassAvailable=businessClassCapacity;
        this.economyClassAvailable=economyClassCapacity;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
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

    @Override
    public String toString() {
        return "Flight{" +
                "airline='" + airline + '\'' +
                ", flightNumber='" + flightNumber + '\'' +
//                ", departureAirport=" + departureAirport +
//                ", arrivalAirport=" + arrivalAirport +
                ", duration='" + duration + '\'' +
                ", price='" + price + '\'' +
//                ", firstClassCapacity=" + firstClassCapacity +
//                ", businessClassCapacity=" + businessClassCapacity +
//                ", economyClassCapacity=" + economyClassCapacity +
                ", firstClassAvailable=" + firstClassAvailable +
                ", businessClassAvailable=" + businessClassAvailable +
                ", economyClassAvailable=" + economyClassAvailable +
                '}';
    }

    public void setArrivalAirport(Airport arrivalAirport) {
        this.arrivalAirport = arrivalAirport;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getFirstClassCapacity() {
        return firstClassCapacity;
    }

    public void setFirstClassCapacity(int firstClassCapacity) {
        this.firstClassCapacity = firstClassCapacity;
    }

    public int getBusinessClassCapacity() {
        return businessClassCapacity;
    }

    public void setBusinessClassCapacity(int businessClassCapacity) {
        this.businessClassCapacity = businessClassCapacity;
    }

    public int getEconomyClassCapacity() {
        return economyClassCapacity;
    }

    public void setEconomyClassCapacity(int economyClassCapacity) {
        this.economyClassCapacity = economyClassCapacity;
    }

    public int getFirstClassAvailable() {
        return firstClassAvailable;
    }

    public void setFirstClassAvailable(int firstClassAvailable) {
        this.firstClassAvailable = firstClassAvailable;
    }

    public int getBusinessClassAvailable() {
        return businessClassAvailable;
    }

    public void setBusinessClassAvailable(int businessClassAvailable) {
        this.businessClassAvailable = businessClassAvailable;
    }

    public int getEconomyClassAvailable() {
        return economyClassAvailable;
    }

    public void setEconomyClassAvailable(int economyClassAvailable) {
        this.economyClassAvailable = economyClassAvailable;
    }
    public void updateFirstClassAvailable(int seats){
        this.firstClassAvailable+=seats;
    }
    public void updateBusinessClassAvailable(int seats){
        this.firstClassAvailable+=seats;
    }
    public void updateEconomyClassAvailable(int seats){
        this.firstClassAvailable+=seats;
    }
}

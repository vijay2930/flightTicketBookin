package com.flightticketbooking.repository;

import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;

import java.util.List;

public class Data {
    private List<Flight> flights;
    private List<User> users;
    private int bookingCount;

    public int getBookingCount() {
        return bookingCount;
    }

    public void setBookingCount(int bookingCount) {
        this.bookingCount = bookingCount;
    }

    //    public Data(List<Flight> flights, List<User> users) {
//        this.flights = flights;
//        this.users = users;
//    }
    public List<Flight> getFlights() {
        return flights;
    }
    public void setFlights(List<Flight> flights) {
        this.flights = flights;
    }
    public List<User> getUsers() {
        return users;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Data{" +
                "flights=" + flights +
                ", users=" + users +
                '}';
    }
}

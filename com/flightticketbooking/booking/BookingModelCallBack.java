package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.MyBooking;

interface BookingModelCallBack {
    void getMyBookings(String user);

    void getFlightForUser(Airport departureAirport, Airport arrivalAirport);

    void addNewBooking(MyBooking myBooking,String user);

    void checkBooking(String id, String user);

    void cancelBooking(MyBooking booking, String user);
}

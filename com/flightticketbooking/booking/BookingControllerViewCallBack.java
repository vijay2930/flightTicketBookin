package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;
import com.flightticketbooking.dto.Passenger;

import java.util.List;

interface BookingControllerViewCallBack {
    void checkIsValidChoice(String user, int choice);

    void checkFlights(Airport departureAirport, Airport arrivalAirport);

    void getConfirmOnBooking(String confirm, Flight flight);

    void checkPassengerCount(Flight flight, String classType, int count);

    void addBookings(Flight flight, List<Passenger> passengers, String classType);

    void checkCardNumber(MyBooking myBooking, String cardNumber, String cardType, String expirationDate, Flight flight, String user);

    void checkBookingExits(String id, String user);

    void checkConfirmCancelling(String confirm, MyBooking booking, String user);
}

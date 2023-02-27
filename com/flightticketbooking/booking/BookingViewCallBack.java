package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;

import java.util.List;

interface BookingViewCallBack {
    void logout();

    void noBookingsToShow();

    void getBookingDetails();

    void noFlightsAvailable();

    void getConfirmationOnBooking(Flight flight);

    void getPassengerCount(Flight flight);

    void returningToBookingPage();

    void ShowMyBookings(List<MyBooking> bookings);

    void getPassengersDetails(Flight flight, String classType, int count);

    void getPayment(MyBooking myBooking, Flight flight);

    void cardIsNotValid(MyBooking myBooking, int tryleft, Flight flight);

    void paymentFailed();

    void bookingSuccessful();

    void getCancelBookingId(String user);

    void noBookingFoundInThatId();

    void confirmCancelBooking(MyBooking booking);

    void abortCancelBooking();

    void cancelledSuccessfully();
}

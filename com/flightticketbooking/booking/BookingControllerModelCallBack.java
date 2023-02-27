package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;

import java.util.List;

interface BookingControllerModelCallBack {
    void isMyBookingsExits(List<MyBooking> myBooking);

    void isFlightAvailable(Flight flight);

    void bookingSuccessful();

    void isMyBookingExits(MyBooking booking);

    void cancelledSuccessfully();
}

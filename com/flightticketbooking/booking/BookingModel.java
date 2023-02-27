package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;
import com.flightticketbooking.repository.Repository;

import java.util.List;

class BookingModel implements BookingModelCallBack {
    private BookingControllerModelCallBack bookingController;
    private Repository repository;
    public BookingModel(BookingControllerModelCallBack bookingController) {
        this.bookingController=bookingController;
        repository=Repository.getInstance();
    }

    @Override
    public void getMyBookings(String user) {
        List<MyBooking> myBookings=repository.getMyBookings(user);
        bookingController.isMyBookingsExits(myBookings);
    }

    @Override
    public void getFlightForUser(Airport departureAirport, Airport arrivalAirport) {
        Flight flight=repository.getFlight(departureAirport,arrivalAirport);
        bookingController.isFlightAvailable(flight);
    }

    @Override
    public void addNewBooking(MyBooking myBooking, String user) {
        repository.addNewBooking(myBooking,user);
        bookingController.bookingSuccessful();
    }

    @Override
    public void checkBooking(String id, String user) {
        MyBooking booking=repository.getMyBooking(id,user);
        bookingController.isMyBookingExits(booking);
    }

    @Override
    public void cancelBooking(MyBooking booking, String user) {
        repository.cancelBooking(booking,user);
        bookingController.cancelledSuccessfully();
    }
}

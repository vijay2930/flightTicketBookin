package com.flightticketbooking.booking;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;
import com.flightticketbooking.dto.Passenger;
import com.flightticketbooking.login.Login;
import com.flightticketbooking.login.LoginView;
import com.flightticketbooking.util.Check;
import com.flightticketbooking.util.Read;

import java.util.ArrayList;
import java.util.List;

public class BookingView implements Booking,BookingViewCallBack{
    String user;
    BookingControllerViewCallBack bookingController;
    public BookingView(String user) {
        this.user = user;
        this.bookingController=new BookingController(this);
    }

    @Override
    public void init() {
        this.start();
    }
    private void start() {
        System.out.println("\nBooking Page");
        System.out.println("1. New Booking");
        System.out.println("2. My Booking");
        System.out.println("3. Cancel Booking");
        System.out.println("4. Logout");
        int choice= Read.changeToInt(Read.input("Enter your choice: "));
        bookingController.checkIsValidChoice(user,choice);
    }
    @Override
    public void logout() {
        System.out.println("Logout successfully");
        System.out.println("Returning to the Login page");
        Check.wait(3000);
        LoginView login=new LoginView();
        login.init();
    }

    @Override
    public void noBookingsToShow() {
        System.out.println("No bookings to Show");
        System.out.println("Returning to the Bookings Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getBookingDetails() {
        System.out.println("\nNew Bookings Page");
        System.out.println("Departure Airport");
        Airport departureAirport=this.getAirportDetails();
        System.out.println("Arrival Airport");
        Airport arrivalAirport=this.getAirportDetails();
        bookingController.checkFlights(departureAirport, arrivalAirport);
    }

    @Override
    public void noFlightsAvailable() {
        System.out.println("\nNo Flights Available");
        System.out.println("Returning to the Booking Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getConfirmationOnBooking(Flight flight) {
        System.out.println("Check the Flights");
        System.out.println(flight);
        String confirm=Read.input("Enter [CONFIRM](in full caps) to continue booking:");
        bookingController.getConfirmOnBooking(confirm,flight);

    }

    @Override
    public void getPassengerCount(Flight flight) {
        System.out.println("\nGet Passenger Count");
        System.out.printf("\nFirst:%d ,Business:%d ,Economy:%d ",flight.getFirstClassAvailable(),
                flight.getBusinessClassAvailable(),flight.getEconomyClassAvailable());
        String classType=Read.input("Enter First/Business/Economy class:");
        int count=Read.changeToInt(Read.input("Enter Passenger Count:"));
        bookingController.checkPassengerCount(flight,classType,count);

    }

    @Override
    public void returningToBookingPage() {
        System.out.println("\nAbort new Booking");
        System.out.println("Returning to the Bookings Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void ShowMyBookings(List<MyBooking> bookings) {
        System.out.println("\n MyBookings Are List Below");
        for (MyBooking booking:bookings) {
            System.out.println(booking);
        }
        System.out.println("Returning to the MyBookings Page");
        this.start();
    }

    @Override
    public void getPassengersDetails(Flight flight, String classType, int count) {
        System.out.println("Enter Passenger Details");
        List<Passenger> passengers=new ArrayList<>();
        for(int i=0;i<count;i++){
            System.out.println("Passenger "+i);
            passengers.add(getPassenger());
        }
        bookingController.addBookings(flight,passengers,classType);
    }

    @Override
    public void getPayment(MyBooking myBooking, Flight flight) {
        System.out.println("Payment Page");
        String cardNumber=Read.input("Enter CardNumber: ");
        String cardType=Read.input("Enter CardType: ");
        String expirationDate=Read.input("Enter ExpirationDate: ");
        bookingController.checkCardNumber(myBooking,cardNumber,cardType,expirationDate,flight, user);
    }

    @Override
    public void cardIsNotValid(MyBooking myBooking, int tryleft, Flight flight) {
        System.out.println("\nCard is Not Valid");
        System.out.println("You have "+tryleft+" tryLeft");
        System.out.println("Please to enter the Valid Card Number");
        System.out.println("Returning To the Payment Page");
        this.getPayment(myBooking,flight);
    }

    @Override
    public void paymentFailed() {
        System.out.println("Payment Failed");
        System.out.println("Booking Failed. Returning to the Bookings Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void bookingSuccessful() {
        System.out.println("\nBooking Successfully");
        System.out.println("Returning to the Booking Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getCancelBookingId(String user) {
        System.out.println("Cancel MyBooking");
        String id=Read.input("Enter Booking Id: ");
        bookingController.checkBookingExits(id,user);
    }

    @Override
    public void noBookingFoundInThatId() {
        System.out.println("\nNo Booking Found in that ID.");
        System.out.println("Returning To that Home page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void confirmCancelBooking(MyBooking booking) {
        System.out.println("\nVerifyn the detail and Then Proceed.");
        System.out.println(booking);
        String confirm=Read.input("Enter [CONFIRM](in full Caps) to confirm:");
        bookingController.checkConfirmCancelling(confirm,booking,this.user);
    }

    @Override
    public void abortCancelBooking() {
        System.out.println("\nAbort Cancelling Flight");
        System.out.println("Returning to the Bookings page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void cancelledSuccessfully() {
        System.out.println("Cancelled Successfully");
        System.out.println("Returning to the Booking Page.");
        Check.wait(3000);
        this.start();
    }


    private Airport getAirportDetails() {
        String name=Read.input("Enter name: ");
        String city=Read.input("Enter city: ");
        String country=Read.input("Enter country: ");
        String time=Read.input("Enter Time(in 24:00 format): ");
        return new Airport(name,city,country,time);
    }
    private Passenger getPassenger(){
        String firstName=Read.input("Enter FirstName:");
        String lastName=Read.input("Enter lastName:");
        String gender=Read.input("Enter gender:");
        int age=Read.changeToInt(Read.input("Enter age:"));
        return new Passenger(firstName,lastName,gender,age);
    }
}

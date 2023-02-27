package com.flightticketbooking.booking;

import com.flightticketbooking.dto.*;
import com.flightticketbooking.util.Check;
import com.flightticketbooking.util.Read;

import java.util.List;

class BookingController implements BookingControllerModelCallBack,BookingControllerViewCallBack{
    int tryLeft=3;
    BookingViewCallBack bookingView;
    BookingModelCallBack bookingModel;
    public BookingController(BookingViewCallBack bookingView) {
        this.bookingView=bookingView;
        this.bookingModel=new BookingModel(this) ;
    }

    @Override
    public void checkIsValidChoice(String user, int choice) {
        switch (choice){
        case 1:
            bookingView.getBookingDetails();
//            code here
            break;
        case 2:
            bookingModel.getMyBookings(user);
//            code here
            break;
        case 3:
            bookingView.getCancelBookingId(user);
//            code here
            break;
        case 4:
            bookingView.logout();
//            code here
            break;

        }
    }

    @Override
    public void checkFlights(Airport departureAirport, Airport arrivalAirport) {
        bookingModel.getFlightForUser(departureAirport,arrivalAirport);
    }

    @Override
    public void getConfirmOnBooking(String confirm, Flight flight) {
        if(confirm.equals("CONFIRM")){
            bookingView.getPassengerCount(flight);
        }else {
            bookingView.returningToBookingPage();
        }
    }

    @Override
    public void checkPassengerCount(Flight flight, String classType, int count) {
        if((classType.equalsIgnoreCase("first") && count<flight.getFirstClassAvailable())||(classType.equalsIgnoreCase("business")&&count<flight.getBusinessClassAvailable())||(classType.equalsIgnoreCase("economy")&&count<flight.getEconomyClassAvailable())){
            bookingView.getPassengersDetails(flight,classType,count);
        }
    }

    @Override
    public void addBookings(Flight flight, List<Passenger> passengers, String classType) {
        float price=0.0f;
        if(classType.equalsIgnoreCase("first")){
            flight.updateFirstClassAvailable(passengers.size()*-1);
            price= Read.changeToFloat(flight.getPrice())*10*passengers.size();
        }
        if(classType.equalsIgnoreCase("Economy")){
            flight.updateEconomyClassAvailable(passengers.size()*-1);
            price= Read.changeToFloat(flight.getPrice())*passengers.size();
        }
        if(classType.equalsIgnoreCase("Business")){
            flight.updateBusinessClassAvailable(passengers.size()*-1);
            price= Read.changeToFloat(flight.getPrice())*5*passengers.size();
        }
        bookingView.getPayment(
        new MyBooking(flight.getFlightNumber(),flight.getAirline(),flight.getDepartureAirport(),
                flight.getArrivalAirport(),classType,price,passengers), flight);
    }

    @Override
    public void checkCardNumber(MyBooking myBooking, String cardNumber, String cardType, String expirationDate, Flight flight, String user) {
        if(!Check.isValidCard(cardNumber)){
            if(tryLeft>0) {
                bookingView.cardIsNotValid(myBooking,tryLeft--,flight);
            }else{
                tryLeft=3;
                String classType=myBooking.getClassType();
                List<Passenger> passengers=myBooking.getPassengers();
                if(classType.equalsIgnoreCase("first")){
                    flight.updateFirstClassAvailable(passengers.size()*1);
                }
                if(classType.equalsIgnoreCase("Economy")){
                    flight.updateEconomyClassAvailable(passengers.size()*1);
                }
                if(classType.equalsIgnoreCase("Business")){
                    flight.updateBusinessClassAvailable(passengers.size()*1);
                }
                bookingView.paymentFailed();
            }
        }else {
            myBooking.setPayment(new Payment(cardNumber,cardType,expirationDate));
            bookingModel.addNewBooking(myBooking,user);
        }
    }

    @Override
    public void checkBookingExits(String id, String user) {
        bookingModel.checkBooking(id, user);
    }

    @Override
    public void checkConfirmCancelling(String confirm, MyBooking booking, String user) {
        if(confirm.equals(confirm)){
            bookingModel.cancelBooking(booking,user);
        }else {
            bookingView.abortCancelBooking();
        }
    }

    @Override
    public void isMyBookingsExits(List<MyBooking> myBooking) {
        if(myBooking.isEmpty()){
            bookingView.noBookingsToShow();
        }else {
            bookingView.ShowMyBookings(myBooking);
        }
    }

    @Override
    public void isFlightAvailable(Flight flight) {
        if(flight==null ||flight.getFirstClassAvailable()==0||flight.getBusinessClassAvailable()==0||flight.getEconomyClassAvailable()==0){
            bookingView.noFlightsAvailable();
        }else {
            bookingView.getConfirmationOnBooking(flight);
        }
    }

    @Override
    public void bookingSuccessful() {
        bookingView.bookingSuccessful();
    }

    @Override
    public void isMyBookingExits(MyBooking booking) {
        if(booking==null){
            bookingView.noBookingFoundInThatId();
        }else {
            bookingView.confirmCancelBooking(booking);
        }
    }

    @Override
    public void cancelledSuccessfully() {
        bookingView.cancelledSuccessfully();
    }
}

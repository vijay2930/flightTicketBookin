package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;

import java.util.List;

class AdminController implements AdminControllerViewCallBack,AdminControllerModelCallBack{
    private AdminViewCallBack adminView;
    private AdminModelCallBack adminModel;
    public AdminController(AdminViewCallBack adminView) {
        this.adminView = adminView;
        this.adminModel=new AdminModel(this);
    }

    @Override
    public void checkIsValidChoice(int choice) {
        switch (choice){
        case 1:
            adminView.getAddFlightDetails();
        case 2:
            adminView.getCancelFlightDetails();
        case 3:
            adminView.getUpdateFlightDetails();
        case 4:
            adminModel.showFlights();
        case 5:
            adminModel.getUsers();
        case 6:
            adminView.logout();
            break;
        default:
            adminView.isNotAValidChoice();
        }
    }

    @Override
    public void addFlightDetails(Flight flight) {
        adminModel.addFlight(flight);
    }

    @Override
    public void getCancellingFlight(String flightNumber, Airport airport) {
        adminModel.getCancellingFlight(flightNumber,airport);
    }

    @Override
    public void checkConfirmationOnCancelingFlight(String confirm, Flight flight) {
        if(confirm.equals("CONFIRM")) {
            adminModel.removeFlight(flight);
        }else {
            adminView.abortCancellingFlight();
        }
    }

    @Override
    public void getUpdatingFlight(String flightNumber, Airport airport) {
        adminModel.getUpdatingFlight(flightNumber,airport);
    }

    @Override
    public void checkConfirmationOnUpdatingFlight(Flight flight, String choice) {
        if(choice.equals("CONFIRM")){
            adminView.getUpdateDetailsOnFlight(flight);
        }else {
            adminView.abortUpdatingFlight();
        }
    }

    @Override
    public void updateFlight(Flight flight, Airport departuerAirport, Airport arrivalAirport, String duration, String price) {
        if(!duration.equalsIgnoreCase("None")){
            flight.setDuration(duration);
        }
        if(price.equalsIgnoreCase("None")){
            flight.setPrice(price);
        }
        flight.getDepartureAirport().update(departuerAirport);
        flight.getArrivalAirport().update(arrivalAirport);
        adminView.updatedFlightSuccessfully();
    }

    @Override
    public void isFlightAddedSuccessully(boolean isAddedSuccessfully) {
        if(isAddedSuccessfully){
            adminView.flightAddedSuccessfully();
        }else {
            adminView.flightAddedFailed();
        }
    }

    @Override
    public void isCancellingFlightExists(Flight flight) {
        if(flight==null){
            adminView.flightNotExits();
        }else {
            adminView.getConfrimCancellingFlight(flight);
        }
    }

    @Override
    public void isFlightRemovedSuccessfully(boolean isFlightRemoved) {
        if(isFlightRemoved){
            adminView.flightRemovedSuccessFull();
        }else {
            adminView.flightRemovalFailed();
        }
    }

    @Override
    public void isUpdatingExits(Flight flight) {
        if(flight==null){
            adminView.flightNotExits();
        }else {
            adminView.getConfirmUpdatingFlight(flight);
        }
    }

    @Override
    public void isFlightsExits(List<Flight> flights) {
        if(flights.isEmpty()){
            adminView.NoFlightsToShow();
        }else {
            adminView.showFlightList(flights);
        }
    }

    @Override
    public void isUsersExits(List<User> users) {
        if(users.isEmpty()){
            adminView.NoUsersToShow();
        }else {
            adminView.showUserList(users);
        }
    }
}

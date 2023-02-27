package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;
import com.flightticketbooking.repository.Repository;

import java.util.List;

class AdminModel implements AdminModelCallBack{
    private AdminControllerModelCallBack adminController;
    private Repository repository;
    public AdminModel(AdminControllerModelCallBack adminController) {
        this.adminController = adminController;
        repository=Repository.getInstance();
    }

    @Override
    public void addFlight(Flight flight) {
        boolean isAddedSuccessfully=repository.addFlight(flight);
        adminController.isFlightAddedSuccessully(isAddedSuccessfully);
    }

    @Override
    public void getCancellingFlight(String flightNumber, Airport airport) {
        Flight flight=repository.getFlight(flightNumber,airport);
        adminController.isCancellingFlightExists(flight);
    }

    @Override
    public void removeFlight(Flight flight) {
        boolean isFlightRemoved=repository.removeFlight(flight);
        adminController.isFlightRemovedSuccessfully(isFlightRemoved);
    }

    @Override
    public void getUpdatingFlight(String flightNumber, Airport airport) {
        Flight flight=repository.getFlight(flightNumber,airport);
        adminController.isUpdatingExits(flight);
    }

    @Override
    public void showFlights() {
        List<Flight> flights=repository.getFlights();
        adminController.isFlightsExits(flights);
    }

    @Override
    public void getUsers() {
        List<User> users=repository.getUsers();
        adminController.isUsersExits(users);
    }

}

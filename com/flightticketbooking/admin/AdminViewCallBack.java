package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;

import java.util.List;

interface AdminViewCallBack {
    void logout();

    void isNotAValidChoice();

    void getAddFlightDetails();

    void flightAddedFailed();

    void flightAddedSuccessfully();

    void getCancelFlightDetails();

    void flightNotExits();

    void getConfrimCancellingFlight(Flight flight);

    void abortCancellingFlight();

    void flightRemovalFailed();

    void flightRemovedSuccessFull();

    void getUpdateFlightDetails();

    void getConfirmUpdatingFlight(Flight flight);

    void abortUpdatingFlight();

    void getUpdateDetailsOnFlight(Flight flight);

    void updatedFlightSuccessfully();

    void NoFlightsToShow();

    void showFlightList(List<Flight> flights);

    void NoUsersToShow();

    void showUserList(List<User> users);
}

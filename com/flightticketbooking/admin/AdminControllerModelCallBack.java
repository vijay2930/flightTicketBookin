package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;

import java.util.List;

interface AdminControllerModelCallBack {
    void isFlightAddedSuccessully(boolean isAddedSuccessfully);

    void isCancellingFlightExists(Flight flight);

    void isFlightRemovedSuccessfully(boolean isFlightRemoved);

    void isUpdatingExits(Flight flight);

    void isFlightsExits(List<Flight> flights);

    void isUsersExits(List<User> users);
}

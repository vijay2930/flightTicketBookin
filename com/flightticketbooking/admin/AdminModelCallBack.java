package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;

interface AdminModelCallBack {
    void addFlight(Flight flight);

    void getCancellingFlight(String flightNumber, Airport airport);

    void removeFlight(Flight flight);

    void getUpdatingFlight(String flightNumber, Airport airport);

    void showFlights();

    void getUsers();
}

package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;

interface AdminControllerViewCallBack {
    void checkIsValidChoice(int choice);

    void addFlightDetails(Flight flight);

    void getCancellingFlight(String flightNumber, Airport airport);

    void checkConfirmationOnCancelingFlight(String confirm,Flight flight);

    void getUpdatingFlight(String flightNumber, Airport airport);

    void checkConfirmationOnUpdatingFlight(Flight flight, String choice);

    void updateFlight(Flight flight, Airport departuerAirport, Airport arrivalAirport, String duration, String price);
}

package com.flightticketbooking.admin;

import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.User;
import com.flightticketbooking.login.Login;
import com.flightticketbooking.login.LoginView;
import com.flightticketbooking.util.Check;
import com.flightticketbooking.util.Read;

import java.util.List;

public class AdminView implements Admin,AdminViewCallBack{
    private AdminControllerViewCallBack adminController;

    public AdminView() {
        this.adminController = new AdminController(this);
    }

    @Override
    public void init() {
        this.start();
    }
    private void start() {
        System.out.println("\nAdmin Page");
        System.out.println("----------");
        System.out.println("1. Add Flight");
        System.out.println("2. Cancel Flight");
        System.out.println("3. Update Flight");
        System.out.println("4. Show Flights");
        System.out.println("5. Show Users");
        System.out.println("6. Logout");
        int choice= Read.changeToInt(Read.input("Enter your choice: "));
        adminController.checkIsValidChoice(choice);

    }
    @Override
    public void logout() {
        System.out.println("\nLogout Successful");
        System.out.println("Returning to the Login Page");
        Check.wait(3000);
        LoginView login=new LoginView();
        login.init();
    }

    @Override
    public void isNotAValidChoice() {
        System.out.println("\nYou have Enter the invalid Choice please try to enter only the valid choice");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getAddFlightDetails() {
        System.out.println("\nAdd Flights Page");
        System.out.println("----------------");
        String airline=Read.input("Enter AirLine: ");
        String flightNumber=Read.input("Enter FlightNumber: ");
        System.out.println("Departure Airport");
        Airport departuerAirport=this.getAirportDetails();
        System.out.println("Arrival Airport");
        Airport arrivalAirport=this.getAirportDetails();
        String duration=Read.input("Enter Duration(00h 00M format): ");
        String price=Read.input("Enter Price:");
        int firstClassCapacity=Read.changeToInt(Read.input("Enter FirstClassCapacity: "));
        int businessClassCapacity=Read.changeToInt(Read.input("Enter BusinessClassCapacity: "));
        int economyClassCapacity=
                Read.changeToInt(Read.input("Enter EconomyClassCapacity: "));
        adminController.addFlightDetails(new Flight(airline,flightNumber,departuerAirport,arrivalAirport,duration,
                price,firstClassCapacity,businessClassCapacity,economyClassCapacity));
    }

    @Override
    public void flightAddedFailed() {
        System.out.println("\nSome thing went wrong.Try again.");
        System.out.println("Returning to the Admin page.");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void flightAddedSuccessfully() {
        System.out.println("Flight added Successfully.");
        System.out.println("Returning to the Admin page.");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getCancelFlightDetails() {
        System.out.println("\nCancel Flight Page");
        System.out.println("------------------");
        String flightNumber=Read.input("Enter Flight Number: ");
        System.out.println("Departure Airport");
        Airport airport=getAirportDetails();
        adminController.getCancellingFlight(flightNumber,airport);
    }

    @Override
    public void flightNotExits() {
        System.out.println("\nFlight Doesn't Exits.");
        System.out.println("Returning to the Admin page.");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getConfrimCancellingFlight(Flight flight) {
        System.out.println("\nVerify the details and the proceed.");
        System.out.println(flight);
        String confirm=Read.input("Enter [CONFIRM](in full cap) to Cancel flight: ");
        adminController.checkConfirmationOnCancelingFlight(confirm, flight);
    }

    @Override
    public void abortCancellingFlight() {
        System.out.println("\nAbort Cancelling Flight");
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void flightRemovalFailed() {
        System.out.println("\nSomething Went Wrong Can't remove Flight.try again.");
        System.out.println("Returning to the Admin Page.");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void flightRemovedSuccessFull() {
        System.out.println("Flight Removed Successfully");
        System.out.println("Returning to the Home Page.");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getUpdateFlightDetails() {
        System.out.println("Update Flight Page");
        String flightNumber= Read.input("Enter FlightNumber: ");
        System.out.println("Departure Airport:");
        Airport airport=getAirportDetails();
        adminController.getUpdatingFlight(flightNumber,airport);
    }

    @Override
    public void getConfirmUpdatingFlight(Flight flight) {
        System.out.println("Verify the Details and then proceed.");
        String choice=Read.input("Enter [CONFIRM](in full caps) to update: ");
        adminController.checkConfirmationOnUpdatingFlight(flight,choice);
    }

    @Override
    public void abortUpdatingFlight() {
        System.out.println("\nAbort Updating Flight");
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getUpdateDetailsOnFlight(Flight flight) {
        System.out.println("If you don't Want to Update the filed the enter [None]");
        System.out.println("Departure Airport");
        Airport departuerAirport=this.getAirportDetails();
        System.out.println("Arrival Airport");
        Airport arrivalAirport=this.getAirportDetails();
        String duration=Read.input("Enter Duration(00h 00M format): ");
        String price=Read.input("Enter Price:");
        adminController.updateFlight(flight,departuerAirport,arrivalAirport,duration,price);
    }

    @Override
    public void updatedFlightSuccessfully() {
        System.out.println("\nFlight Updated Successfully");
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void NoFlightsToShow() {
        System.out.println("\nFlight list is Empty");
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void showFlightList(List<Flight> flights) {
        System.out.println("The Flight Details are Listed below");
        for (Flight flight:flights) {
            System.out.println(flight);
        }
        Check.wait(1000);
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void NoUsersToShow() {
        System.out.println("\nUser List is Empty");
        System.out.println("Returning to the Admin Page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void showUserList(List<User> users) {
        System.out.println("The User Details are Listed below");
        for (User user:users) {
            System.out.println(user);
        }
        Check.wait(1000);
        System.out.println("Returning to the Admin Page");
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
}

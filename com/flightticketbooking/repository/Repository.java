package com.flightticketbooking.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.flightticketbooking.dto.Airport;
import com.flightticketbooking.dto.Flight;
import com.flightticketbooking.dto.MyBooking;
import com.flightticketbooking.dto.User;
import com.flightticketbooking.util.Read;

import java.io.File;
import java.util.HashMap;
import java.util.List;

public class Repository {
    private static Repository db;
    private Data data;
    private HashMap<String,User> userList=new HashMap<>();
    private Repository(){
        this.readData();
    }
    public static Repository getInstance(){
        if(db==null){
            db=new Repository();
        }
        return db;
    }
    private void readData(){
        try{
            ObjectMapper mapper=new ObjectMapper();
            data=(Data) mapper.readValue(new File("D:\\workspace\\IntelliJ\\ConcoleApplication\\src\\com" +
                    "\\flightticketbooking" +
                    "\\repository\\data.json"),Data.class);
            for (User user:data.getUsers()) {
                this.userList.put(user.getEmail(),user);
            }
            MyBooking.setBookingCount(data.getBookingCount());
        }catch (Exception e){e.printStackTrace();}
    }
    private void writeData(){
        try{
            ObjectMapper mapper=new ObjectMapper();
            this.data.setBookingCount(MyBooking.getBookingCount());
            mapper.writeValue(new File("D:\\workspace\\IntelliJ\\ConcoleApplication\\src\\com\\flightticketbooking" +
                    "\\repository\\data.json"),this.data);
        }catch (Exception e){e.printStackTrace();}
    }
    public void exit(){
        this.writeData();
    }

    public User getUser(String email, String password) {
        if(this.userList.containsKey(email)){
            if(!this.userList.get(email).getIsAdmin() && this.userList.get(email).getPassword().equals(password))
                return userList.get(email);
        }
        return null;
    }

    public User getAdmin(String email, String password) {
        if(this.userList.containsKey(email)){
            if(this.userList.get(email).getIsAdmin() && this.userList.get(email).getPassword().equals(password))
                System.out.println(userList.get(email));
                return userList.get(email);
        }
        return null;
    }

    public User addNewUser(User user) {
        if(this.userList.containsKey(user.getEmail())){
            return null;
        }
        this.userList.put(user.getEmail(),user);
        data.getUsers().add(user);
        return this.userList.get(user.getEmail());
    }

    public boolean addFlight(Flight flight) {
        return data.getFlights().add(flight);
    }

    public Flight getFlight(String flightNumber, Airport airport) {
        for(Flight flight:data.getFlights()){
            if(flight.getFlightNumber().equals(flightNumber) && flight.getDepartureAirport().equals(airport)){
                return flight;
            }
        }
        return null;
    }
    public Flight getFlight(Airport departure, Airport arrival) {
        for(Flight flight:data.getFlights()){
            if(flight.getArrivalAirport().equals(arrival)&& flight.getDepartureAirport().equals(departure)){
                return flight;
            }
        }
        return null;
    }

    public boolean removeFlight(Flight flight) {
        return data.getFlights().remove(flight);
    }

    public List<Flight> getFlights() {
        return data.getFlights();
    }

    public List<User> getUsers() {
        return data.getUsers();
    }

    public List<MyBooking> getMyBookings(String user) {
        return this.userList.get(user).getMyBooking();
    }

    public void addNewBooking(MyBooking myBooking, String user) {
        this.userList.get(user).getMyBooking().add(myBooking);
    }

    public MyBooking getMyBooking(String id,String user) {
        for(MyBooking booking:this.userList.get(user).getMyBooking()){
            if(booking.getBookingId()==Read.changeToInt(id)){
                return booking;
            }
        }
        return null;
    }
    public void cancelBooking(MyBooking booking, String user) {
        String flightNumber=booking.getFlightNumber();
        Flight flight=null;
        for(Flight temp:data.getFlights()){
            System.out.println(flightNumber+":"+temp.getFlightNumber());
            System.out.println(flightNumber.equals(temp.getFlightNumber()));
            if(temp.getFlightNumber().equals(flightNumber)){
                flight=temp;
                break;
            }
        }
        String classType=booking.getClassType();
        if(classType.equalsIgnoreCase("first")){
            flight.updateFirstClassAvailable(booking.getPassengers().size());
        }else if(classType.equalsIgnoreCase("business")){
            flight.updateBusinessClassAvailable(booking.getPassengers().size());
        }else if(classType.equalsIgnoreCase("economy")){
            flight.updateEconomyClassAvailable(booking.getPassengers().size());
        }
        this.userList.get(user).getMyBooking().remove(booking);
    }
}

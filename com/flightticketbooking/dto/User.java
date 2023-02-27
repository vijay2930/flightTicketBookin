package com.flightticketbooking.dto;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
    private boolean isAdmin;
    private List<MyBooking> myBooking;

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
//                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
//                ", myBooking=" + myBooking +
                '}';
    }

    public User() {
    }

    public User(String firstName, String lastName, String email, String password, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isAdmin=false;
        this.myBooking=new ArrayList<>();
    }

    public User(String firstName, String lastName, String email, String password, String phone, boolean isAdmin,
                List<MyBooking> myBooking) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isAdmin = isAdmin;
        this.myBooking = myBooking;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(boolean isAdmin) {
        this.isAdmin = isAdmin;
    }

    public List<MyBooking> getMyBooking() {
        return myBooking;
    }

    public void setMyBooking(List<MyBooking> myBooking) {
        this.myBooking = myBooking;
    }
}

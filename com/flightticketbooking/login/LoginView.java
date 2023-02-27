package com.flightticketbooking.login;

import com.flightticketbooking.admin.Admin;
import com.flightticketbooking.admin.AdminView;
import com.flightticketbooking.booking.Booking;
import com.flightticketbooking.booking.BookingView;
import com.flightticketbooking.util.Check;
import com.flightticketbooking.util.Read;
public class LoginView implements LoginViewCallBack{
    private LoginControllerViewCallBack loginController;
    public LoginView() {
        loginController=new LoginController(this);
    }
    public void init() {this.start();}
    public void start(){
        System.out.println("\n-------------------------------------------------");
        System.out.println("Welcome To Our Flight Ticket Booking Applications");
        System.out.println("-------------------------------------------------\n");
        System.out.println("Login Page");
        System.out.println("----------");
        System.out.println("1. User Login");
        System.out.println("2. User SignUp");
        System.out.println("3. Admin Login");
        System.out.println("4. Exit");
        int choice= Read.changeToInt(Read.input("Please Enter your Choice: "));
        this.checkIsValidChoice(choice);
    }

    private void checkIsValidChoice(int choice) {
        switch (choice) {
        case 1:
            this.getLoginInfo("User");
            break;
        case 2:
            this.createNewUser();
            break;
        case 3:
            this.getLoginInfo("Admin");
            break;
        case 4:
            loginController.exit();
            System.exit(0);
            break;
        default:
            this.isNotAValidChoice();
        }
    }

    @Override
    public void isNotAValidChoice() {
        System.out.println("\nYou have Enter the invalid Choice please try to enter only the valid choice");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void getLoginInfo(String info) {
        System.out.printf("\n%5s Page\n",info);
        System.out.println("------------");
        String email=Read.input("Enter your Email: ");
        String password=Read.input("Enter your Password: ");
        loginController.validateLoginInfo(info,email,password);
    }

    @Override
    public void isNotValidEmail(int tryLeft, String info) {
        System.out.println("\nEmail you provided was not a Valid email");
        System.out.printf("Try Again. You have %d try's left",tryLeft);
        Check.wait(3000);
        this.getLoginInfo(info);
    }

    @Override
    public void returnToLoginPage() {
        System.out.println("\nReturning To the Home page");
        Check.wait(3000);
        this.start();
    }

    @Override
    public void userLoginSuccessFull(String user) {
        System.out.println("\nThank you For Login");
        System.out.printf("Welcome %s\n",user);
        Check.wait(3000);
        Booking booking=new BookingView(user);
        booking.init();
//      Redirecting to bookings page
    }

    @Override
    public void loginFailed(String info, int tryLeft) {
        System.out.println("\nUser Id or Password is Incorrect");
        System.out.printf("Try Again. You have %d try's left",tryLeft);
        Check.wait(3000);
        getLoginInfo(info);
    }

    @Override
    public void adminLoginSuccessFull(String user) {
        System.out.println("\nThank you For Login");
        System.out.printf("Welcome %s\n",user);
        Check.wait(3000);
//        Redirect
        Admin admin=new AdminView();
        admin.init();
    }

    @Override
    public void createNewUser() {
        System.out.println("\nSign up Page");
        System.out.println("-------------");
        String firstName=Read.input("Enter firstName: ");
        String lastName=Read.input("Enter lastName: ");
        String email=Read.input("Enter email: ");
        String password=Read.input("Enter password: ");
        String phone=Read.input("Enter phone: ");
        loginController.validateNewUser(firstName,lastName,email,password,phone);
    }

    @Override
    public void newUserValidationFailed(String msg, int signUpTry) {
        System.out.printf("\n %s you provided is not Valid. Please enter the valid email.",msg);
        System.out.printf("\nyou Have %d Try Left",signUpTry);
        System.out.println("Returning to the SignUp page.");
        Check.wait(3000);
        this.createNewUser();
    }

    @Override
    public void userCreationFailed(int signUpFailed) {
        System.out.println("\nEmail you provided was already exist.");
        System.out.println("Try to signup with another email id.");
        System.out.printf("You have %d Try left",signUpFailed);
        System.out.println("Returning to the signUp page.");
        Check.wait(3000);
        this.createNewUser();
    }

    @Override
    public void userCreatedSuccessfully(String user) {
        System.out.println("\nThank you for Signing up.");
        System.out.println("SignUp Successfully");
        System.out.printf("Welcome %s", user);
//      Redirect
        Check.wait(3000);
        Booking booking=new BookingView(user);
        booking.init();
    }

}

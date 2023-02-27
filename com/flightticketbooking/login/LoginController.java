package com.flightticketbooking.login;

import com.flightticketbooking.dto.User;
import com.flightticketbooking.util.Check;

class LoginController implements LoginControllerModelCallBack, LoginControllerViewCallBack {
    private LoginViewCallBack loginView;
    private LoginModelCallBack loginModel;

    private int emailTry = 3;
    private int loginTry = 3;
    private int signupTry = 3;
    private int signupFailed=3;

    public LoginController(LoginViewCallBack loginView) {
        this.loginView = loginView;
        this.loginModel = new LoginModel(this);
    }

    @Override
    public void checkIsValidChoice(int choice) {
        switch (choice) {
        case 1:
            loginView.getLoginInfo("User");
//            code goes here
            break;
        case 2:
            loginView.createNewUser();
//            code goes here
            break;
        case 3:
            loginView.getLoginInfo("Admin");
//            code goes here
            break;
        case 4:
            loginModel.exit();
            System.exit(0);
//            code goes here
            break;
        default:
            loginView.isNotAValidChoice();
        }
    }

    @Override
    public void validateLoginInfo(String info, String email, String password) {
        if (Check.isValidEmail(email)) {
            this.emailTry = 3;
            if (info.equals("User"))
                loginModel.checkUserExist(email, password);
            if (info.equals("Admin"))
                loginModel.checkAdminExist(email, password);
        } else
            if (emailTry > 0) {
                loginView.isNotValidEmail(this.emailTry--, "User");
            } else {
                this.emailTry = 3;
                loginView.returnToLoginPage();
            }
    }

    @Override
    public void validateNewUser(String firstName, String lastName, String email, String password, String phone) {
        if(!Check.isValidEmail(email)){
            if(signupTry>0) {
                System.out.println(Check.isValidEmail(email));
                loginView.newUserValidationFailed("email", signupTry--);
            } else
                loginView.returnToLoginPage();
        }else if(!Check.isValidMobileNo(phone)){
            if(signupTry>0)
                loginView.newUserValidationFailed("Phone no",signupTry--);
            else
                loginView.returnToLoginPage();
        }else {
            signupTry=3;
            User user=new User(firstName,lastName,email,password,phone);
            loginModel.addNewUser(user);
        }
    }

    @Override
    public void exit() {
        loginModel.exit();
    }

    @Override
    public void isUserLoginSuccessful(User user) {
        if (user == null) {
            if (loginTry > 0)
                loginView.loginFailed("User", loginTry--);
            else
                loginView.returnToLoginPage();
        } else {
            loginTry = 3;
            loginView.userLoginSuccessFull(user.getEmail());
        }
    }

    @Override
    public void isAdminLoginSuccessful(User admin) {
        if (admin == null) {
            if (loginTry > 0)
                loginView.loginFailed("Admin", emailTry--);
            else
                loginView.returnToLoginPage();
        } else {
            loginTry = 3;
            loginView.adminLoginSuccessFull(admin.getEmail());
        }
    }

    @Override
    public void isUserCreatedSuccessfull(User user) {

        if(user==null){
            if(signupFailed>0)
                loginView.userCreationFailed(signupFailed--);
            else
                loginView.returnToLoginPage();
        }else {
            loginView.userCreatedSuccessfully(user.getEmail());
        }
    }
}

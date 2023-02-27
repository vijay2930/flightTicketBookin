package com.flightticketbooking.login;

import com.flightticketbooking.dto.User;
import com.flightticketbooking.repository.Repository;

class LoginModel implements LoginModelCallBack{
    private LoginControllerModelCallBack loginController;
    private Repository repository;
    public LoginModel(LoginControllerModelCallBack loginController) {
        this.loginController = loginController;
        repository=Repository.getInstance();
    }
    @Override
    public void exit() {
        repository.exit();
    }
    @Override
    public void checkUserExist(String email, String password) {
        User user=repository.getUser(email,password);
        loginController.isUserLoginSuccessful(user);
    }

    @Override
    public void checkAdminExist(String email, String password) {
        User admin=repository.getAdmin(email,password);
        loginController.isAdminLoginSuccessful(admin);
    }

    @Override
    public void addNewUser(User user) {
        User newUser=repository.addNewUser(user);
        loginController.isUserCreatedSuccessfull(newUser);
    }
}

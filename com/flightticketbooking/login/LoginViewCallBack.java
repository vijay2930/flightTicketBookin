package com.flightticketbooking.login;

interface LoginViewCallBack {
    void isNotAValidChoice();

    void getLoginInfo(String info);

    void isNotValidEmail(int tryLeft, String info);

    void returnToLoginPage();

    void userLoginSuccessFull(String user);

    void loginFailed(String info, int tryLeft);

    void adminLoginSuccessFull(String email);

    void createNewUser();

    void newUserValidationFailed(String msg, int signUpTry);

    void userCreationFailed(int SingupFailed);

    void userCreatedSuccessfully(String user);
}

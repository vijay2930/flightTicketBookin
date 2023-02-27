package com.flightticketbooking.login;

import com.flightticketbooking.dto.User;

interface LoginControllerModelCallBack {
    void isUserLoginSuccessful(User user);

    void isAdminLoginSuccessful(User admin);

    void isUserCreatedSuccessfull(User user);
}

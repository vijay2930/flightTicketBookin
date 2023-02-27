package com.flightticketbooking.login;

import com.flightticketbooking.dto.User;

interface LoginModelCallBack {
    void exit();

    void checkUserExist(String email, String password);

    void checkAdminExist(String email, String password);

    void addNewUser(User user);
}

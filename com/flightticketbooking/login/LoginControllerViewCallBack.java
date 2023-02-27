package com.flightticketbooking.login;

import com.flightticketbooking.util.Check;

interface LoginControllerViewCallBack {
    void checkIsValidChoice(int choice);

    void validateLoginInfo(String info, String email, String password);

    void validateNewUser(String firstName, String lastName, String email, String password, String phone);

    void exit();
}

package com.flightticketbooking.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Check {
    public static boolean isValidEmail(String email){
        String EMAIL_REGEX = "^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$";
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    public static boolean isValidMobileNo(String mobileNumber) {
        String MOBILE_NUMBER_PATTERN = "^(\\+\\d{1,3}[- ]?)?\\d{10}$";
        Pattern pattern = Pattern.compile(MOBILE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
    public static boolean isValidCard(String cardNumber){
            String cleanedCardNumber = cardNumber.replaceAll("\\s+|-", "");
            if (!cleanedCardNumber.matches("^\\d{13,19}$")) {
                return false;
            }
            String regex = "(\\d{4})(\\d{4})?(\\d{4})?(\\d{4})?";
            return cleanedCardNumber.matches(regex);
    }
    public static void wait(int seconds){
        try{Thread.sleep(seconds*1000);}catch (Exception e){}
    }
}

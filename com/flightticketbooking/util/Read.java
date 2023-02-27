package com.flightticketbooking.util;

import java.util.Scanner;

public class Read {
    private static Scanner sc=new Scanner(System.in);
    public static String input(String prompt){
        while (true){
            try{
                System.out.print(prompt);
                String val=sc.nextLine();
                if(!val.isBlank())
                    return val;
            }catch (Exception e){e.printStackTrace();}
        }
    }
    public static int changeToInt(String str){
        try{
            return Integer.parseInt(str);
        }catch (Exception e){e.printStackTrace();}
        return 0;
    }
    public static float changeToFloat(String str){
        try{
            return Float.parseFloat(str);
        }catch (Exception e){e.printStackTrace();}
        return 0.0f;
    }
}

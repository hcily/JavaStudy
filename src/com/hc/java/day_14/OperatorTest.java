package com.hc.java.day_14;

public class OperatorTest {

    public static void main(String args[]){

        if(true || isOK()){
            System.out.println("===>>> main");
        }
    }


    private static boolean isOK(){

        System.out.println("===>>> isOK");

        return false;
    }



}

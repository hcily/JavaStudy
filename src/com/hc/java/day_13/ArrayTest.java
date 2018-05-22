package com.hc.java.day_13;

public class ArrayTest {

    public static void main(String args[]) {
        int[] a = new int[]{1, 2, 3, 4};

        System.out.println("===>>> a:" + a.toString());

        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance());
        System.out.println("===>>> mInstance: " + getInstance_2());
        System.out.println("===>>> mInstance: " + getInstance_2());
        System.out.println("===>>> mInstance: " + getInstance_2());
        System.out.println("===>>> mInstance: " + getInstance_2());
        System.out.println("===>>> mInstance: " + getInstance_2());
    }

    private static ArrayTest mInstance;

    private ArrayTest() {
    }

    public static ArrayTest getInstance() {
        if (mInstance == null) {
            synchronized (ArrayTest.class) {
                if (mInstance == null) {
                    mInstance = new ArrayTest();
                }
            }
        }
        return mInstance;
    }

    public static ArrayTest getInstance_2() {
        return Inner.instance;
    }

    private static class Inner {
        private static ArrayTest instance;
        static {
            instance = new ArrayTest();
        }
    }
}

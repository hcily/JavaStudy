package com.hc.java.day_15;

public class SuperOrThisTest {

    interface _A {


//        static {
//
//        }
    }

    static class A {

        int status;

        private A() {
            System.out.println("A");
        }


        A(int status) {
            this.status = status;
        }


        void print() {

            System.out.println("base:");
        }
    }


    static class B extends A {

        int status;

        B() {
            System.out.println("B");
        }

        B(int status) {
            super(status - 1);
            this.status = status;
        }


        void printBase() {
            super.print();
            System.out.println(super.status);
        }

        void printSub() {
            System.out.println("Sub:");
            System.out.println(this.status);
        }

    }


    public static void main(String args[]) {

        B b = new B();

        C c = new C(5);

        B _b = new B(3);
        _b.printBase();
        _b.printSub();

    }
}


class C extends SuperOrThisTest.A {

    C(int status) {
        super(status);
    }
}

class _C implements SuperOrThisTest._A {

    _C() {
        super();
    }
}



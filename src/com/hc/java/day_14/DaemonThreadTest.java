package com.hc.java.day_14;

public class DaemonThreadTest {


    private static class Runnal implements Runnable {

        @Override
        public void run() {
            for (int i = 0; i < 10000000; i++) {
                System.out.println("守护线程：" + i);
            }
        }
    }

    public static void main(String args[]) {

        Thread thread = new Thread(new Runnal());
        thread.setDaemon(true);
        thread.start();
    }
}

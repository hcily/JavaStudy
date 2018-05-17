package com.hc.java.day_11;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class StaticVariateThreadSafeTest {


    // volatile关键字能保证可见性，但是不能保证原子性
    // x++和 x = x+1包括3个操作：读取x的值，进行加1操作，写入新的值。
    volatile public static   int a = 0;

    Lock lock = new ReentrantLock();

    public void addA(){
        new Thread() {
            @Override
            public void run() {
                super.run();
                lock.lock();
                try {
//                synchronized (StaticVariateThreadSafeTest.class) {
                    for (int i = 0; i < 1000; i++)
                        a++;
//                }
                }finally {
                    lock.unlock();
                }

                System.out.println("a = " + a);
            }
        }.start();
    }

    public static void main(String args[]) {

        StaticVariateThreadSafeTest threadSafeTest = new StaticVariateThreadSafeTest();

        for (int i = 0; i < 100; i++) {
            threadSafeTest.addA();
        }

    }
}

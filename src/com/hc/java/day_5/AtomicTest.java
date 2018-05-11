package com.hc.java.day_5;

import java.util.concurrent.atomic.LongAdder;

/**
 * @author cathcool
 * @version 创建时间：2018年4月18日 下午11:42:41 类说明
 */
public class AtomicTest {
	static long a = 0;
	static LongAdder longAdder = new LongAdder();

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 1000; i++) {
						longAdder.increment();
					}
					System.out.println(this + ", longAdder:" + longAdder.longValue());
				}
			}).start();
		}

		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {

				@Override
				public void run() {
					// TODO Auto-generated method stub
					for (int i = 0; i < 1000; i++) {
						a++;
					}
					System.out.println(this + ", a:" + a);
				}
			}).start();
		}

	}
}

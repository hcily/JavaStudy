package com.hc.java.day_7;

/**
 * @author cathcool
 * @version 创建时间：2018年4月22日 下午11:49:22 类说明
 */
public class JoinTest {

	public static void main(String[] args) {
		Thread thread1 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				// TODO Auto-generated method stub
				try {
					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("===>>> " + "thread1");
			
			}
		});

		Thread thread2 = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					thread1.start();
					thread1.join();
//					Thread.sleep(2000);
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("===>>> " + "thread2");
			}
		});

		try {

			thread2.start();
//			thread1.start();

			thread2.join();
//			thread1.join();
			
			System.out.println("===>>> " + "main");

			// thread1.start();

			// thread2.start();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}

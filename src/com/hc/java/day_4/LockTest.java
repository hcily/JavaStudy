package com.hc.java.day_4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cathcool
 * @version 创建时间：2018年4月17日 下午12:46:07 类说明
 */
public class LockTest {
	public static void main(String[] args) throws InterruptedException {

		final ExecutorService exec = Executors.newFixedThreadPool(4);

		final ReentrantLock lock = new ReentrantLock();

		final Condition con = lock.newCondition();

		final int time = 0;

		final Runnable add = new Runnable() {

			public void run() {

				System.out.println("Pre " + lock);

				lock.lock();

				try {
					System.out.println("Mid " + lock);

					con.await(time, TimeUnit.MILLISECONDS);
					// Thread.sleep(500);

				} catch (InterruptedException e) {

					e.printStackTrace();

				} finally {

					System.out.println("Post " + lock.toString());

					lock.unlock();

					System.out.println("End " + lock.toString());
				}

			}

		};

		for (int index = 0; index < 4; index++)

			exec.submit(add);

		exec.shutdown();

	}
}

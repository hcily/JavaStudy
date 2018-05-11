package com.hc.java.day_4;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author cathcool
 * @version 创建时间：2018年4月17日 下午2:09:26 类说明
 */
public class LockTest2 {

	public static void main(String[] args) {
		ReentrantLock lock = new ReentrantLock();
		Condition condition = lock.newCondition();
		new Thread(new NumberPrinter(lock, condition)).start();
		new Thread(new LetterPrinter(lock, condition)).start();
	}
}

class NumberPrinter implements Runnable {

	ReentrantLock lock;
	Condition condition;

	public NumberPrinter(ReentrantLock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		lock.lock();

		int max = 26;

		try {

			int period = 1;
			int count = 1;

			while (count <= max) {
				for (int i = 0; i < period; i++) {
					System.out.print(count);
					count++;
				}
				condition.signalAll();
				if (count > max) {
					break;
				}
				condition.await();
			}

		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// System.out.println();
			// System.out.println("End, this:" + this + ", lock:" + this.lock);
			lock.unlock();
		}
	}
}

class LetterPrinter implements Runnable {

	ReentrantLock lock;
	Condition condition;

	public LetterPrinter(ReentrantLock lock, Condition condition) {
		this.lock = lock;
		this.condition = condition;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		lock.lock();

		char max = 'Z';

		try {

			int period = 1;
			char count = 'A';

			while (count <= max) {
				for (int i = 0; i < period; i++) {
					System.out.print("-" + count + "-");
					count++;
				}
				condition.signalAll();
				if (count > max) {
					break;
				}
				condition.await();
			}
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			// System.out.println();
			// System.out.println("End, this:" + this + ", lock:" + this.lock);
			lock.unlock();
		}
	}
}

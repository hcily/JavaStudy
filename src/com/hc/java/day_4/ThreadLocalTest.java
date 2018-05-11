package com.hc.java.day_4;

/**
 * @author cathcool
 * @version 创建时间：2018年4月17日 下午3:52:14 类说明
 */
public class ThreadLocalTest {

	public static void main(String[] args) {
		SequenceNumber sequenceNumber = new SequenceNumber();

		new Thread(new TestClient(sequenceNumber)).start();
		new Thread(new TestClient(sequenceNumber)).start();
		new Thread(new TestClient(sequenceNumber)).start();

		System.out.println(Thread.currentThread() + ":" + sequenceNumber.getNextNum());
	}

}

class TestClient implements Runnable {

	SequenceNumber threadLocal;

	public TestClient(SequenceNumber threadLocal) {
		// TODO Auto-generated constructor stub
		super();
		this.threadLocal = threadLocal;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		for (int i = 0; i < 3; i++) {
			System.out.println(Thread.currentThread() + ", " + i + ":" + threadLocal.getNextNum());
		}
	}
}

class SequenceNumber {
	ThreadLocal<Integer> threadLocal;

	public SequenceNumber() {
		// TODO Auto-generated constructor stub
		threadLocal = new ThreadLocal<>();
	}

	public int getNextNum() {
		Integer integer = threadLocal.get();
		integer = integer == null ? 0 : integer;
		threadLocal.set(integer + 1);
		return integer;
	}
}

package com.hc.java.day_1;

/**
 * @author cathcool
 * @version 创建时间：2018年4月6日 下午5:00:24 类成员加载顺序测试
 */
public class MemberLoadOrderTestMain {

	private static final String TAG = MemberLoadOrderTestMain.class.getName();

	private int memberA = 10;
	private static int memberB = 11;

	private MemberLoadOrderTestMain() {
		System.out.println(TAG + "===>>> construction MemberLoadOrderTest ");
		memberA = 13;
		memberB = 14;
	}

	public int getMemberA() {
		System.out.println(TAG + "===>>> getMemberA memberA:" + memberA);
		return memberA;
	}

	static {
		memberB = 12;
		System.out.println(TAG + "===>>> static block memberB:" + memberB);
	}

	{
		System.out.println(TAG + "===>>> normal block memberA:" + memberA);
		memberA = 15;
	}

	public static void main(String[] args) {
		System.out.println(TAG + "===>>> main ");

		System.out.println("\n");
		
		LoadOrderTestA.getMemberB();
		
		System.out.println("\n");
		
		LoadOrderTestA loadOrderTestA = new LoadOrderTestA();
		loadOrderTestA.getMemberA();

		System.out.println("\n");
		
		LoadOrderTestB loadOrderTestB = new LoadOrderTestB();
		loadOrderTestB.getMemberA();
		// MemberLoadOrderTest memberLoadOrderTest = new MemberLoadOrderTest();
		// memberLoadOrderTest.getMemberA();
	}

	public void first() {

	}
}

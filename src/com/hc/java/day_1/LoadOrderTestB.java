package com.hc.java.day_1;

/**
 * @author cathcool
 * @version 创建时间：2018年4月6日 下午5:32:13 类说明
 */
public class LoadOrderTestB extends LoadOrderTestA{
	private static final String TAG = LoadOrderTestB.class.getName();

	//private int memberA = 10;
	protected static int memberB = 11;

	public LoadOrderTestB() {
		System.out.println(TAG + "===>>> construction LoadOrderTestB ");
		memberA = 16;
		memberB = 14;
	}

	public LoadOrderTestB(int param) {
		System.out.println(TAG + "===>>> construction param LoadOrderTestB ");
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

}

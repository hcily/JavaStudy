package com.hc.java.day_1;

/**
 * @author cathcool
 * @version 创建时间：2018年4月6日 下午5:32:13 类说明
 */
public class LoadOrderTestA {
	private static final String TAG = LoadOrderTestA.class.getName();

	protected int memberA = 10;
	private static int memberB = 11;

	public LoadOrderTestA() {
		System.out.println(TAG + "===>>> construction  LoadOrderTestA ");
		memberA = 13;
		memberB = 14;
	}
	
	
	public LoadOrderTestA(int param) {
		System.out.println(TAG + "===>>> construction param LoadOrderTestA ");
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
	

	public static int getMemberB() {
		System.out.println(TAG + "===>>> getMemberB memberB:" + memberB);
		return memberB;
	}
}

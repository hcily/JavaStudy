package com.hc.java.day_3;

/**
 * @author cathcool
 * @version 创建时间：2018年4月16日 下午8:48:19 类说明
 */
public class SynchroLockTest {

	static Object aObject = new Object();

	static Object bObject = aObject;

	public static void main(String[] args) {
		synchronized (aObject) {

			System.out.println("1 : lock a");
			synchronized (aObject) {
				System.out.println("2 : lock a");
			}
		}
	}
}

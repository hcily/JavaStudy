package com.hc.java.day_7;

/**
 * @author cathcool
 * @version 创建时间：2018年4月21日 下午12:01:40 类说明
 */
public class OuterClass {
	
	public int a = 99;

	class InnerClass {
			public void printA() {
				System.out.println("===>>> a:" + a);
			}
	}

	static class StaticInnerClass {
			
	}

	public void printInnerClass() {
		InnerClass innerClass = new InnerClass();
		System.out.println("===>>> " + innerClass);
	}

	public static void main(String[] args) {
		
		InnerClass innerClass = new OuterClass().new InnerClass();

		System.out.println("===>>> " + innerClass);
		innerClass.printA();
		
		new OuterClass().printInnerClass();

		StaticInnerClass staticInnerClass = new StaticInnerClass();

		System.out.println("===>>> " + staticInnerClass);

		class A {

			public void name() {

			}

		}

		A a = new A();

		System.out.println("===>>> " + a);

	}
}

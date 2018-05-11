package com.hc.java.day_6;

/**
 * @author cathcool
 * @version 创建时间：2018年4月19日 下午10:20:17 类说明
 */
public class SuperSelfTest {

	public static void main(String[] args) {
		Father father = new Father();
		father.speak();

		Son son = new Son();
		son.speak();

		System.out.println("" + Son.class.getSuperclass());
		System.out.println("" + son.getClass().getSuperclass());
	}
}

class Father {

	public Father() {
		System.out.println("===>>> Father");
	}

	public Father(int a) {
		System.out.println("===>>> Father. a:" + a);
	}

	public void speak() {
		System.out.println("Father. Self: " + this);
		System.out.println("Father. Self: " + this.getClass());
		System.out.println("Father. Super: " + super.getClass());
	}

}

class Son extends Father {
	//
	// public Son() {
	// // super();
	// // 如果子类构造函数中没有写super()函数，编译器会自动帮我们添加一个无参数的super()
	// System.out.println("===>>> Son");
	// }
	//
	// public Son(int a) {
	// // super();
	// // 如果子类构造函数中没有写super()函数，编译器会自动帮我们添加一个无参数的super()
	// System.out.println("===>>> Son. a:" + a);
	// }

	public void speak() {
		super.speak();
		System.out.println("Son. Self: " + this);
		System.out.println("Son. Self: " + this.getClass());
		System.out.println("Son. Super: " + super.getClass());
	}
}

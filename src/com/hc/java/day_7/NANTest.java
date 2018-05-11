package com.hc.java.day_7;

/**
 * @author cathcool
 * @version 创建时间：2018年4月22日 下午9:48:11 类说明
 */
public class NANTest {

	public static void main(String[] args) {
		
		System.out.println(Double.isNaN(Double.POSITIVE_INFINITY));
		
		System.out.println(Double.isNaN(Double.NEGATIVE_INFINITY));
		
		System.out.println(Double.isNaN(Double.longBitsToDouble(0x7ff0000000000011L)));
		
		
		Float f1 = new Float(-1.0 / 0.0);
        Float f2 = new Float(0.0 / 0.0);
        Double f3 = Math.sqrt(-1);

        // returns true if this Float value is a Not-a-Number(NaN), else false
        System.out.println(f1 + " = " + f1.toString());
        System.out.println(f1 + " = " + f1.isNaN());
        System.out.println(f2 + " = " + f2.isNaN());
        System.out.println(f3 + " = " + f3.isNaN());
	}
}

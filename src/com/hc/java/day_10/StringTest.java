package com.hc.java.day_10;

public class StringTest {

    public static void main(String args[]) {

        test_1();

        test_3();

        test_4();

        test_5();

        test_6();

        test_7();

        test_11();

    }

    public static void test_1() {
        String a = "chenssy";
        String b = "chenssy";
        String c = new String("chenssy");
        System.out.println("===========test1============");
        System.out.println(a == b); //true
        System.out.println(a == c); //false
    }

    public static void test_3() {
        String s0 = "helloworld";
        String s1 = "helloworld";
        String s2 = "hello" + "world";
        System.out.println("===========test3============");
        System.out.println(s0 == s1); //true 可以看出s0跟s1是指向同一个对象
        System.out.println(s0 == s2); //true 可以看出s0跟s2是指向同一个对象
    }

    public static void test_4() {
        String s0 = "helloworld";
        String s1 = new String("helloworld");
        String s2 = "hello" + new String("world");
        System.out.println("===========test4============");
        System.out.println(s0 == s1); //false
        System.out.println(s0 == s2); //false
        System.out.println(s1 == s2); //false
    }

    public static void test_5() {

        String str1 = "abc";
        String str2 = "def";
        String str3 = str1 + str2;
        String str4 = "abcdef";
        System.out.println("===========test_5============");
        System.out.println(str3 == "abcdef"); //false
        System.out.println(str3 == str4); //false
        System.out.println(str4 == "abcdef"); //true


        // JVM对String str="abc"对象放在常量池中是在编译时做的，
        // 而String str3=str1+str2是在运行时刻才能知道的。new对象也是在运行时才做的。
    }

    public static void test_6() {
        String s0 = "a1";
        String s1 = "a" + 1;
        System.out.println("===========test6============");
        System.out.println((s0 == s1)); //result = true
        String s2 = "atrue";
        String s3 = "a" + "true";
        System.out.println((s2 == s3)); //result = true
        String s4 = "a3.4";
        String s5 = "a" + 3.4;
        System.out.println((s4 == s5)); //result = true
        // 在程序编译期，JVM就将常量字符串的"+"连接优化为连接后的值，拿"a" + 1来说，经编译器优化后在class中就已经是a1。
        // 在编译期其字符串常量的值就确定下来，故上面程序最终的结果都为true。
    }

    /**
     * 编译期无法确定
     */
    public static void test_7() {
        String s0 = "ab";
        String s1 = "b";
        String s2 = "a" + s1;
        System.out.println("===========test7============");
        System.out.println((s0 == s2)); //result = false
    }

    /**
     * 比较字符串常量的“+”和字符串引用的“+”的区别
     */
    public void test_8() {
        String test = "javalanguagespecification";
        String str = "java";
        String str1 = "language";
        String str2 = "specification";
        System.out.println("===========test8============");
        System.out.println(test == "java" + "language" + "specification"); // 编译期
        System.out.println(test == str + str1 + str2);   // 运行期
    }

    /**
     * 编译期确定
     */
    public static void test_9() {
        String s0 = "ab";
        final String s1 = "b";
        String s2 = "a" + s1 + "c";
        System.out.println("===========test9============");
        System.out.println((s0 == s2)); //result = true
    }


    /**
     * 编译期无法确定
     */
    public static void test_10() {
        String s0 = "ab";
        final String s1 = getS1();
        String s2 = "a" + s1;
        System.out.println("===========test10============");
        System.out.println((s0 == s2)); //result = false

    }

    private static String getS1() {
        return "b";
    }


    public static void test_11() {
        String a = "abc";
        String b = new String(a);
        System.out.println("===========test11============");
        System.out.println((a == b));
        System.out.println((a == b.intern()));
    }


    public static void test_12() {
        String s = null;
        for (int i = 0; i < 100; i++) {
            s += "a";
        }

    }
}

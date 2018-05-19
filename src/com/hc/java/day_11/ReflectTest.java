package com.hc.java.day_11;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectTest {


   public static class TestClass {

        private int num;

        public void setNum(int num) {
            this.num = num;
        }

        public int getNum() {
            return num;
        }
    }

    public static void main(String args[]) {
        long now;
        long sum = 0;
        TestClass t = new TestClass();

        now = System.currentTimeMillis();

        for (int i = 0; i < 500000; ++i) {
            t.setNum(i);
            sum += t.getNum();
        }

        System.out.println("get-set耗时" + (System.currentTimeMillis() - now) + "ms秒，和是" + sum);

        sum = 0;
        now = System.currentTimeMillis();

        try {

            for (int i = 0; i < 500000; ++i) {
                Class<?> c = Class.forName("com.hc.java.day_11.ReflectTest$TestClass");
                Class<?>[] argsType = new Class[1];
                argsType[0] = int.class;
                Method m = c.getMethod("setNum", argsType);
                m.invoke(t, i);
                sum += t.getNum();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {

        }
        System.out.println("标准反射耗时" + (System.currentTimeMillis() - now) + "ms，和是" + sum);

        sum = 0;

        try {

            Class<?> c = Class.forName("com.hc.java.day_11.ReflectTest$TestClass");
            Class<?>[] argsType = new Class[1];
            argsType[0] = int.class;
            Method m = c.getMethod("setNum", argsType);

            now = System.currentTimeMillis();

            for (int i = 0; i < 500000; ++i) {
                m.invoke(t, i);
                sum += t.getNum();
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {

        }
        System.out.println("缓存反射耗时" + (System.currentTimeMillis() - now) + "ms，和是" + sum);

        sum = 0;

//        try {
//
//            MethodAccess ma = MethodAccess.get(TestClass.class);
//            int index = ma.getIndex("setNum");
//            now = System.currentTimeMillis();
//
//            for (int i = 0; i < 500000; ++i) {
//                ma.invoke(t, index, i);
//                sum += t.getNum();
//            }
//        } catch (ClassNotFoundException | NoSuchMethodException | InvocationTargetException | IllegalAccessException e) {
//
//        }
        System.out.println("reflectasm反射耗时" + (System.currentTimeMillis() - now) + "ms，和是" + sum);
    }
}

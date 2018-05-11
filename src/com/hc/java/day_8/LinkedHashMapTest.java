package com.hc.java.day_8;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @author cathcool
 * @version 创建时间：2018年4月30日 下午6:27:57 类说明
 */
public class LinkedHashMapTest {

	public static void main(String[] args) {

		// accessOrder 这就是基于访问的顺序，get一个元素后，这个元素被加到最后(使用了LRU 最近最少被使用的调度算法)
		LinkedHashMap<Integer, String> linkedHashMap = new LinkedHashMap<>(4, 0.75f, true);
		linkedHashMap.put(1, "a");
		linkedHashMap.put(2, "b");
		linkedHashMap.put(3, "c");
		linkedHashMap.put(4, "d");
		linkedHashMap.put(5, "e");
		
		linkedHashMap.get(1);
		linkedHashMap.get(3);
		linkedHashMap.get(1);

		Iterator<String> iterator = linkedHashMap.values().iterator();
		while (iterator.hasNext()) {
			String s = iterator.next();
			System.out.println("===>>> s:" + s);
		}

	}
}

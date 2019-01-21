package com.java.se.conclusion.collection.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * 	This is a class to test Map
 * 	-- 2 ways of traversing a map: key set + foreach, entry set + foreach (for interview question)
 * 	-- Using generics in Map type (dynamic-array-like): Map (for interview question)
 *  -- Type parameter (<>): Short, Integer, Long, Double, Float, Character, Byte, Boolean, String, etc
 * 
 * @author VinceYuan
 *
 */
public class TestMap {

	/*	Necessary instance variables	*/
	private Map<String, String> map;
	
	/**
	 * 	This is a main method for execution
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		TestMap testMap = new TestMap();
		testMap.testPreparation();
		testMap.testMap();
		testMap.testMapKey();
	}
	
	/**
	 * 	This is a method for test preparation
	 */
	private void testPreparation() {
		
		/* 	Define a map and add some entries	*/
		map = new HashMap<>();
//		map = new LinkedHashMap<>();
//		map = new TreeMap<>();
//		map = new Hashtable<>();
		map.put("aaa", "111");
		map.put("bbb", "222");
		map.put("ccc", "222");
		map.put("ccc", "333");
		map.put("ddd", "222");
	}
	
	/**
	 * 	Test Map
	 */
	private void testMap() {
		
		/*	Put some entries	*/
		map.put("eee", "456");
		map.putAll(map);
		
		/*	Remove some entries	 */
		String key = "eee";
		map.remove("eee");
		
		/*	Get or find some entries	*/
		key = "ccc";
		System.out.println("If key " + key + " exists:\n" + map.containsKey(key));
		System.out.println("The value of key " + key + ":\n" + map.get(key));
		
		/*	Modify some entries	 */
		key = "ccc";
		map.put(key, map.get(key).concat("ccc"));
		
		/* 	Output by using 2 traversing way: key set; entry set	*/
		traverseMap(map);
		
		/*	Clear the map	*/
		map.clear();
		System.out.println("If the map is empty:\n" + map.isEmpty());
	}
	
	/**
	 * 	This is a method to traverse a map using key set, entry set respectively
	 * @param map
	 */
	private <K, V> void traverseMap(Map<K, V> map) {

		System.out.println("Use key set + foreach to traverse a map:");
		Set<K> KeySet = map.keySet();					// Return a set (***) such that it can use foreach
		for (K key : KeySet) {
			V value = map.get(key);
			System.out.println(key + " " + value);
		}
		
		System.out.println("Use entry set + foreach to traverse a map:");
		Set<Entry<K, V>> EntrySet = map.entrySet();		// Return a set (***) such that it can use foreach
		for (Entry<K, V> entry : EntrySet) {
			K key = entry.getKey();
			V value = entry.getValue();
			System.out.println(key + " " + value);
		}	
	}
	
	private void testMapKey() {
		
		Map<Long, Integer> map = new HashMap<>();
		map.put(4844256082L, 123456);
		map.put(1234567890L, 654321);
		map.put(Long.MAX_VALUE, 666666);
		map.put(8997878003191L, 555555);
		map.put(9999999999999L, 888888);
		System.out.println(map);
		
		Long key1 = 9999999999999L;
		Long key2 = Long.valueOf("9999999999999");
		Long key3 = Long.parseLong("9999999999999");
		Long key4 = new Long("9999999999999");
		Long[] keys = { key1, key2, key3, key4 };
		for (Long key : keys) {
			System.out.println(key + " ---> " + map.get(key));
		}
	}
}

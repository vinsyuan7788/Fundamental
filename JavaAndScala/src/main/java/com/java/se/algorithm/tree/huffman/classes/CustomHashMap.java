package com.java.se.algorithm.tree.huffman.classes;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CustomHashMap<K, V> implements Serializable {

	private static final long serialVersionUID = 1L;
	private static int DEFAULT_CAPACITY = 16;  
    private static double A = (Math.pow(5, 0.5) - 1) / 2;  
  
    private int capacity;  
    private int size = 0;  
  
    private Node<K, V>[] buckets;  
  
    public CustomHashMap() {  
        this(DEFAULT_CAPACITY);  
    }  
  
    @SuppressWarnings("unchecked")  
    public CustomHashMap(int capacity) {  
        if (capacity <= 0) {  
            throw new IllegalArgumentException(  
                    "capacity can not be negative or zero");  
        }  
        int temp = 1;  
        while (temp < capacity) {  
            temp <<= 2;  
        }  
        this.capacity = temp;  
  
        buckets = new Node[this.capacity];  
    }  
  
    public void insert(K key, V value) {  
        if (key == null) {  
            throw new IllegalArgumentException("key can not be null");  
        }  
  
        int position = index(key);  
  
        Node<K, V> node = new Node<K, V>(key, value);  
        if (buckets[position] != null) {  
            node.setNext(buckets[position]);  
        }  
  
        buckets[position] = node;  
        size++;  
    }  
  
    public void put(K key, V value) {  
        if (key == null) {  
            throw new IllegalArgumentException("key can not be null");  
        }  
  
        int position = index(key);  
  
        Node<K, V> node = buckets[position];  
  
        while (node != null) {  
            if (node.key.equals(key)) {  
                node.value = value;  
                return;  
            }  
  
            node = node.next;  
        }  
  
        Node<K, V> newNode = new Node<K, V>(key, value);  
        if (buckets[position] != null) {  
            newNode.setNext(buckets[position]);  
        }  
  
        buckets[position] = newNode;  
        size++;  
    }  
  
    public void delete(K key) {  
        if (key == null) {  
            throw new IllegalArgumentException("key can not be null");  
        }  
  
        int position = index(key);  
        Node<K, V> node = buckets[position];  
  
        if (node == null) {  
            return;  
        }  
  
        if (node.key.equals(key)) {  
            buckets[position] = node.next;  
            size--;  
        }  
  
        while (node.next != null) {  
            if (node.next.key.equals(key)) {  
                node.next = node.next.next;  
                size--;  
                break;  
            }  
  
            node = node.next;  
        }  
    }  
  
    public V search(K key) {  
        if (key == null) {  
            throw new IllegalArgumentException("key can not be null");  
        }  
  
        int position = index(key);  
        Node<K, V> node = buckets[position];  
  
        while (node != null) {  
            if (node.key.equals(key)) {  
                return node.value;  
            }  
  
            node = node.next;  
        }  
  
        return null;  
    }  
   
	public List<K> keySet() {
		
		List<K> keyList = new ArrayList<K>();
		
		for (int i = 0; i < buckets.length; i++) {
			K key = buckets[i].key;
			keyList.add(key);
		}
		
		return keyList;
	}   
  
    public int size() {  
        return size;  
    }  
  
    public boolean isEmpty() {  
        return size == 0;  
    }  
  
    @Override  
    public String toString() {  
        StringBuffer buffer = new StringBuffer();  
        buffer.append("{");  
  
        for (int i = 0; i < capacity; i++) {  
            Node<K, V> node = buckets[i];  
            while (node != null) {  
                buffer.append(node.key + ":" + node.value + ", ");  
                node = node.next;  
            }  
        }  
  
        if (buffer.length() > 1) {  
            buffer.delete(buffer.length() - 2, buffer.length());  
        }  
  
        buffer.append("}");  
  
        return buffer.toString();  
    }  
  
    private int index(K key) {  
        int hashCode = key.hashCode();  
  
        double temp = hashCode * A;  
        double digit = temp - Math.floor(temp);  
  
        return (int) Math.floor(digit * capacity);  
    }  
  
    static class Node<K, V> implements Serializable {  
		private static final long serialVersionUID = 1L;
		private final K key;  
        private V value;  
        private Node<K, V> next;  
  
        public Node(K key, V value) {  
            this.key = key;  
            this.value = value;  
        }  
  
        public V getValue() {  
            return value;  
        }  
  
        public void setValue(V value) {  
            this.value = value;  
        }  
  
        public Node<K, V> getNext() {  
            return next;  
        }  
  
        public void setNext(Node<K, V> next) {  
            this.next = next;  
        }  
  
        public K getKey() {  
            return key;  
        }  
    }
}

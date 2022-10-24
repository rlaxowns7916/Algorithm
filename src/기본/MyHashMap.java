package 기본;

import java.util.Objects;

public class MyHashMap<K, V> {

  public static void main(String[] args) {
    MyHashMap<String, Integer> myHashMap = new MyHashMap<>(10);

    myHashMap.put("a", 1);
    myHashMap.put("b", 2);
    myHashMap.put("c", 3);
    myHashMap.put("d", 4);
    myHashMap.put("e", 5);
    myHashMap.put("f", 6);
    myHashMap.put("g", 7);
    myHashMap.put("h", 8);
    myHashMap.put("i", 9);

    myHashMap.remove("i");
    myHashMap.remove("b");

    System.out.println(myHashMap.get("a"));
  }

  public MyHashMap(int size) {
    this.size = size;
    buckets = new MyLinkedList[size];

    for (int i = 0; i < size; i++) {
      buckets[i] = new MyLinkedList<>();
    }
  }

  private int size = 0;
  private MyLinkedList<K, V>[] buckets;

  public void put(K key, V value) {
    int bucketIndex = selectBuckets(key);
    buckets[bucketIndex].add(key, value);
  }

  public V remove(K key) {
    int bucketIndex = selectBuckets(key);
    Object result = buckets[bucketIndex].remove(key);

    if (result == null) {
      throw new RuntimeException("No Such Key");
    } else {
      return (V) result;
    }
  }

  public V get(K key) {
    int bucketIndex = selectBuckets(key);
    Object result = buckets[bucketIndex].get(key);

    if (result == null) {
      throw new RuntimeException("No Such Key");
    } else {
      return (V) result;
    }
  }

  private int selectBuckets(K key) {
    return Objects.hash(key) % size;
  }

}

class MyLinkedList<K, V> {

  Node<K, V> head;
  Node<K, V> tail;

  public V get(K key) {
    Node<K, V> target = null;
    Node<K, V> cursor = head;

    while (cursor != null) {
      if (cursor.key.equals(key)) {
        target = cursor;
        break;
      }
    }

    return target == null ? null : target.value;
  }

  public void add(K key, V value) {
    Node node = new Node(key, value);

    if (head == null && tail == null) {
      head = tail = node;
    } else {
      tail.next = node;
      tail = node;
    }
  }

  public V remove(K key) {
    Node<K, V> target = null;
    Node<K, V> prev = null;
    Node<K, V> cursor = head;
    while (cursor != null) {
      if (cursor.key.equals(key)) {
        if (prev != null) {
          prev.next = cursor.next;
        } else {
          head = tail = null;
        }
        target = cursor;
        break;
      }
      prev = cursor;
    }
    return target == null ? null : target.value;
  }

  class Node<K, V> {

    K key;
    V value;

    Node<K, V> next;

    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
  }

}
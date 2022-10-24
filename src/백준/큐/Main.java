package 백준.큐;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    MyQueue<Integer> queue = new MyQueue();
    int N = Integer.parseInt(br.readLine());

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());

      String operation = st.nextToken();
      if (operation.equals("push")) {
        int value = Integer.parseInt(st.nextToken());
        queue.add(value);
      } else {
        sb.append(print(queue, operation));
      }
    }
    System.out.println(sb);
  }

  public static String print(MyQueue<Integer> queue, String operation) {
    StringBuilder sb = new StringBuilder();

    if (operation.equals("front")) {
      Integer result = queue.getFront();
      sb.append(result == null ? -1 : result);

    } else if (operation.equals("back")) {
      Integer result = queue.getTail();
      sb.append(result == null ? -1 : result);
    } else if (operation.equals("size")) {
      sb.append(queue.getSize());
    } else if (operation.equals("empty")) {
      boolean result = queue.isEmpty();
      sb.append(result ? 1 : 0);
    } else {
      Integer result = queue.pop();
      sb.append(result == null ? -1 : result);
    }
    sb.append("\n");
    return sb.toString();
  }
}

class MyQueue<T> {

  Node<T> tail = null;
  Node<T> head = null;

  private int size = 0;

  public void add(T value) {
    Node newNode = new Node(value);
    if (tail == null && head == null) {
      head = tail = newNode;
    } else {
      tail.next = newNode;
      tail = newNode;
    }
    size++;
  }

  public T pop() {
    if (isEmpty()) {
      return null;
    } else {
      Node<T> target = head;
      head = target.next;

      if (head == null) {
        tail = null;
      }

      size--;
      return target.value;
    }
  }

  public int getSize() {
    return this.size;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public T getFront() {
    return this.head == null ? null : head.value;
  }

  public T getTail() {
    return this.tail == null ? null : tail.value;
  }


}

class Node<T> {

  Node next;
  T value;

  public Node(T value) {
    this.value = value;
  }
}

package 백준.스택;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());
    MyStack<Integer> stack = new MyStack<>();

    while (N-- > 0) {
      st = new StringTokenizer(br.readLine());
      String operation = st.nextToken();

      if (operation.equals("push")) {
        int value = Integer.parseInt(st.nextToken());
        stack.push(value);
      } else {
        sb.append(print(stack, operation));
      }
    }
    System.out.println(sb);
  }

  public static String print(MyStack<Integer> stack, String operation) {
    StringBuilder sb = new StringBuilder();

    if (operation.equals("top")) {
      Integer result = stack.getTop();
      sb.append(result == null ? -1 : result);
    } else if (operation.equals("empty")) {
      sb.append(stack.isEmpty() ? 1 : 0);
    } else if (operation.equals("size")) {
      sb.append(stack.getSize());
    } else {
      Integer result = stack.pop();
      sb.append(result == null ? -1 : result);
    }

    sb.append("\n");
    return sb.toString();
  }
}

class MyStack<T> {

  private Node<T> head = null;
  private int size = 0;

  public void push(T value) {
    Node<T> target = new Node(value);
    if (head != null) {
      target.next = head;
    }
    head = target;
    size++;
  }

  public T pop() {
    if (head == null) {
      return null;
    } else {
      Node<T> target = head;
      head = head.next;
      size--;
      return target.value;
    }
  }

  public T getTop() {
    return this.head == null ? null : head.value;
  }

  public boolean isEmpty() {
    return this.size == 0;
  }

  public int getSize() {
    return this.size;
  }
}

class Node<T> {

  Node next;
  T value;

  public Node(T value) {
    this.value = value;
  }
}

package 기본;

import java.util.Arrays;
import java.util.Queue;

public class Stack<T> {

  public static void main(String[] args) {
    Stack<Integer> st = new Stack<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 20; i++) {
      st.push((int) (Math.random() * 100) + 1);
    }

    while (!st.isEmpty()) {
      sb.append(st.pop()).append(" ");
    }

    System.out.println(sb);
    System.out.println(st.peek());
    st.pop();
  }
  private final int DEFAULT_SIZE = 10;
  private Object[] buffer = new Object[DEFAULT_SIZE];
  private int count = 0;

  public void push(T data) {
    if (count == buffer.length) {
      grow();
    }
    buffer[count++] = data;
  }

  public boolean isEmpty() {
    return count == 0;
  }

  public T pop() {
    if (count <= 0) {
      throw new IllegalArgumentException("Stack is Empty");
    }
    T target = (T) buffer[--count];
    buffer[count] = null;

    return target;
  }

  public T peek() {
    return (T) (this.buffer[count]);
  }

  private void grow() {
    int newBufferSize = buffer.length * 2;
    buffer = Arrays.copyOf(buffer, newBufferSize);
  }

}

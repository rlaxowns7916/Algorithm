package 기본;

public class Queue<T> {

  public static void main(String[] args) {
    Queue<Integer> queue = new Queue<>();
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < 20; i++) {
      queue.enqueue((int) (Math.random() * 100) + 1);
    }

    while (!queue.isEmpty()) {
      sb.append(queue.dequeue()).append(" ");
    }
    System.out.println(queue.isEmpty());
    System.out.println(sb);
    queue.enqueue(18);
    System.out.println(queue.dequeue());
  }

  private Node<T> head;
  private Node<T> tail;
  private int size = 0;

  public void enqueue(T data) {
    Node<T> target = new Node<>(data);
    if (size == 0) {
      head = tail = target;
    } else {
      tail.next = target;
      tail = target;
    }
    size++;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T dequeue() {
    if (size <= 0) {
      throw new IllegalArgumentException("Queue is Empty");
    }
    Node<T> target = head;
    head = head.next;
    size--;

    return target.data;
  }

  private static class Node<T> {

    T data;
    Node<T> next = null;

    public Node(T data) {
      this.data = data;
    }
  }
}

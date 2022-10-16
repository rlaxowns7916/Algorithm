package 기본;

public class LinkedList<T> {

  public static void main(String[] args) {
    LinkedList<Integer> list = new LinkedList<>();

    for (int i = 0; i < 10; i++) {
      list.add((int) (Math.random() * 100));
    }

    for (int i = 0; i < 10; i++) {
      System.out.println(list.get(i));
    }

    list.delete(1);
    list.delete(7);
    list.add(99, 0);
    System.out.println("---------------");
    for (int i = 0; i < 8; i++) {
      System.out.println(list.get(i));
    }
  }


  private Node<T> head = null;
  private Node<T> tail = null;

  public T get(int index) {
    Node<T> target = seaarch(index);
    return target == null ? null : target.getValue();
  }

  public T add(T val) {
    Node<T> target = new Node<>(val);
    if (head == null) {
      head = tail = target;
    } else {
      tail.setNext(target);
      tail = target;
    }
    return target.getValue();
  }

  public T add(T val, int index) {
    Node<T> target = new Node<>(val);
    if (index > 0) {
      Node<T> prev = seaarch(index - 1);
      prev.setNext(target);
      if (tail == prev) {
        tail = target;
      }
    } else if (index == 0) {
      target.setNext(head);
      head = target;
    } else {
      return null;
    }

    return target.getValue();
  }

  public T delete(int index) {
    Node<T> prev = seaarch(index - 1);

    if (prev == null || prev.getNext() == null) {
      return null;
    }

    Node<T> target = prev.getNext();
    prev.setNext(target.getNext());

    return target.getValue();
  }

  private Node<T> seaarch(int index) {
    Node<T> current = head;
    for (int i = 0; i < index && current != null; i++) {
      current = current.getNext();
    }
    return current;
  }

  class Node<T> {

    private Node<T> next;
    private T val = null;

    public Node(T val) {
      this.val = val;
    }

    public Node<T> getNext() {
      return next;
    }

    public void setNext(Node<T> node) {
      this.next = node;
    }

    public T getValue() {
      return val;
    }
  }
}
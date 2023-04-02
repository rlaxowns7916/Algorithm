package 백준.덱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args)
      throws IOException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    Deque deque = new Deque();

    for(int i=0;i<n;i++){
      StringTokenizer st = new StringTokenizer(br.readLine());
      String command = st.nextToken();

      if(st.hasMoreTokens()){
        int value = Integer.parseInt(st.nextToken());
        Method method = Deque.class.getMethod(command,int.class);
        method.invoke(deque,value);
      }else{
        Method method = Deque.class.getMethod(command);
        sb.append(method.invoke(deque)).append("\n");
      }
    }
    System.out.println(sb);
  }
}

class Deque{

  Node front = null;

  Node back = null;
  int length = 0;

  public void push_front(int value){
    Node target = new Node(value);
    if(front == null && back == null && length == 0){
      front = back = target;
    }else{
      front.prev = target;
      target.next = front;
      front = target;
    }
    length++;
  }
  public void push_back(int value){
    Node target = new Node(value);
    if(front == null && back == null && length == 0){
      front = back = target;
    }else{
      back.next = target;
      target.prev = back;
      back = target;
    }
    length++;
  }

  public int pop_front(){
    if(front == null && length == 0){
      return -1;
    }else{
      Node target = front;
      front = front.next;
      target.next = null;

      length--;
      if(length == 0){
        front = back = null;
      }
      return target.value;
    }
  }
  public int pop_back(){
    if(back == null && length == 0){
      return -1;
    }else{
      Node target = back;
      back = back.prev;

      target.prev = null;
      length--;
      if(length == 0){
        front = back = null;
      }
      return target.value;
    }
  }

  public int size(){
    return length;
  }

  public int empty(){
    return length == 0 ? 1: 0;
  }
  public int front(){
    if(length == 0){
      return -1;
    }
    return front.value;
  }
  public int back(){
    if(length == 0){
      return -1;
    }
    return back.value;
  }
}

class Node{
  int value = 0;
  Node next = null;
  Node prev = null;

  public Node(int value){
    this.value = value;
  }
}

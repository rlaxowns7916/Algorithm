package 백준.도서관;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

  public static int n = 0, m = 0;

  public static void main(String[] args) throws IOException {
    int result = 0,max=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    PriorityQueue<Integer> negative = new PriorityQueue<>((o1,o2) -> o2-o1);
    PriorityQueue<Integer> positive = new PriorityQueue<>(((o1, o2) -> o2 - o1));

    n = Integer.parseInt(st.nextToken());
    m = Integer.parseInt(st.nextToken());
    st = new StringTokenizer(br.readLine());

    for (int i = 0; i < n; i++) {
      int number = Integer.parseInt(st.nextToken());
      if (number > 0) {
        positive.add(number);
      } else {
        negative.add(Math.abs(number));
      }
    }

    if(!positive.isEmpty() && !negative.isEmpty()){
      max = Math.max(negative.peek(),positive.peek());
    }else if(!negative.isEmpty()){
      max = negative.peek();
    }else if(!positive.isEmpty()){
      max = positive.peek();
    }

    while(!negative.isEmpty()){
      result += Math.abs(negative.peek())*2;
      move(negative,m);
    }
    while(!positive.isEmpty()){
      result += positive.peek()*2;
      move(positive,m);
    }
    System.out.println(result-max);
  }

  public static void move(PriorityQueue<Integer> position , int m) {
    for (int i = 0; i < m ; i++) {
      position.poll();
    }
  }
}

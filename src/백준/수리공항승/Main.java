package 백준.수리공항승;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    int stickers=0,index=0;
    double start=0,end=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()), L = Integer.parseInt(st.nextToken());
    List<Integer> list = new ArrayList<>();

    String input = br.readLine();
    st = new StringTokenizer(input);

    for(int i=0;i<N;i++){
      list.add(Integer.parseInt(st.nextToken()));
    }

    Collections.sort(list);


    start = list.get(0)-0.5;
    while(index < N){
      end = list.get(index) + 0.5;

      if(end - start > L){
        start = list.get(index) - 0.5;
        stickers++;
      }
      index++;
    }
    System.out.println(stickers+1);
  }

}

package 백준.문자열집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

  public static int N=0,M=0;
  public static void main(String[] args) throws IOException {
    int count = 0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Set<String> set = new LinkedHashSet<>();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=0;i<N;i++){
      set.add(br.readLine());
    }

    for(int i=0;i<M;i++){
      if(set.contains(br.readLine())){
        count++;
      }
    }
    System.out.println(count);
  }
}

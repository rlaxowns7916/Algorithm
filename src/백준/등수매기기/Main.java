package 백준.등수매기기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

  public static void main(String[] args) throws IOException {
    int rank=1;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    long score=0;

    List<Integer> expected = new ArrayList<>();

    for(int i=0;i<n;i++){
      expected.add(Integer.parseInt(br.readLine()));
    }
    Collections.sort(expected);

    for(int num : expected){
      score += Math.abs(num - rank++);
    }
  System.out.println(score);
  }
}

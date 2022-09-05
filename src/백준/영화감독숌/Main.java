package 백준.영화감독숌;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int target = Integer.parseInt(br.readLine()), count = 0;
    long num = 666;

    while (true) {
      String str = String.valueOf(num);
      if (str.contains("666")) {
        count++;
      }
      if (count == target) {
        break;
      }
      num++;
    }
    System.out.println(num);
  }

}

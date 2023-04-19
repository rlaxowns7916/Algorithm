package 백준.진법변환2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int num = Integer.parseInt(st.nextToken());
    int expression = Integer.parseInt(st.nextToken());

    while (num > 0) {
      int mod = num % expression;
      num /= expression;

      if (mod < 10) {
        sb.append(mod);
      } else {
        sb.append(getCharacter(mod));
      }
    }
    System.out.println(sb.reverse());
  }

  public static char getCharacter(int mod) {
    return (char) ('A' + (mod - 10));
  }
}
package 백준.폴리오미노;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    boolean canFind = true;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st = new StringTokenizer(input, ".", true);

    String longOne = "AAAA";
    String shortOne = "BB";

    while (st.hasMoreTokens()) {
      String token = st.nextToken();
      if (token.equals(".")) {
        sb.append(token);
      } else if (token.length() % 2 == 1) {
        canFind = false;
        break;
      } else {
        int longLength = token.length() / longOne.length();
        int shorLength = (token.length() - longOne.length() * longLength) / shortOne.length();
        sb.append(longOne.repeat(longLength)).append(shortOne.repeat(shorLength));
      }
    }
    if (canFind) {
      System.out.println(sb);
    } else {
      System.out.println(-1);
    }
  }
}

package 백준.펠린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    int[] alphabets = new int[26];
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    for (int i = 0; i < input.length(); i++) {
      char chr = input.charAt(i);
      alphabets[chr - 'A']++;
    }

    System.out.println(solve(input, alphabets));
  }

  public static String solve(String input, int[] alphabets) {
    StringBuilder sb = new StringBuilder();
    int oddIndex = -1;
    if (input.length() % 2 == 1) {
      for (int i=0;i < alphabets.length;i++) {
        if (alphabets[i] % 2 == 1) {
          if (oddIndex != -1) {
            return "I'm Sorry Hansoo";
          } else {
            oddIndex = i;
          }
        }
      }
    } else {
      for (int alphabet : alphabets) {
        if (alphabet % 2 == 1) {
          return "I'm Sorry Hansoo";
        }
      }
    }

    for (int i = 0; i < alphabets.length; i++) {
      if (alphabets[i] == 0) {
        continue;
      } else if (alphabets[i] % 2 == 1) {
        oddIndex = i;
      }
      sb.append(String.valueOf((char) (i + 'A')).repeat(alphabets[i] / 2));

    }

    String origin = sb.toString();
    String reverse = sb.reverse().toString();

    if (oddIndex == -1) {
      return origin + reverse;
    } else {
      return origin + (char) (oddIndex + 'A') + reverse;
    }
  }
}

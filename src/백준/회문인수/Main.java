package 백준.회문인수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      int num = Integer.parseInt(br.readLine());
      boolean find = false;
      for (int i = 2; i <= 64; i++) {
        if (isPalindrome(calculate(num, i))) {
          find = true;
          break;
        }
      }

      if (find) {
        sb.append(1);
      } else {
        sb.append(0);
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }

  public static String calculate(int num, int expression) {
    StringBuilder sb = new StringBuilder();

    while (num > 0) {
      int mod = num % expression;
      num /= expression;

      sb.append((char)mod);
    }
    return sb.reverse().toString();
  }

  public static boolean isPalindrome(String target) {
    for (int i = 0; i < target.length() / 2; i++) {
      if (target.charAt(i) != target.charAt(target.length() - 1 - i)) {
        return false;
      }
    }
    return true;
  }

}

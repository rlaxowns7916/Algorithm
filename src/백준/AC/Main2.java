package 백준.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {

  public static int T = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    T = Integer.parseInt(br.readLine());

    while (T-- > 0) {
      boolean isReverse = false;
      boolean isError = false;
      Deque<String> element = new LinkedList<>();

      String command = br.readLine();
      int size = Integer.parseInt(br.readLine());

      String input = br.readLine();
      StringTokenizer st = new StringTokenizer(input.substring(1, input.length() - 1), ",");
      for (int i = 0; i < size; i++) {

        element.addLast(st.nextToken());
      }

      for (int i = 0; i < command.length(); i++) {
        char ch = command.charAt(i);
        if (ch == 'R') {
          isReverse = !isReverse;
        } else {
          if (element.isEmpty()) {
            sb.append("error");
            isError = true;
            break;
          }
          else if (isReverse) {
            element.removeLast();
          } else {
            element.removeFirst();
          }
        }
      }

      if (!isError) {
        sb.append("[");
        if (isReverse) {
          while (!element.isEmpty()) {
            sb.append(element.removeLast()).append(",");
          }
        } else {
          while (!element.isEmpty()) {
            sb.append(element.removeFirst()).append(",");
          }
        }
        if (sb.charAt(sb.length() - 1) == ',') {
          sb.deleteCharAt(sb.lastIndexOf(","));
        }
        sb.append("]");
      }
      sb.append("\n");
    }
    System.out.println(sb.deleteCharAt(sb.length() - 1));
  }
}

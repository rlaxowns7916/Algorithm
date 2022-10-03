package 백준.LRUCaching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

  public static void main(String[] args) throws IOException {
    int turn = 1, cacheSize = 0;
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    HashMap<Character, Character> keys;
    Deque<Character> values;

    while (true) {
      keys = new LinkedHashMap<>();
      values = new LinkedList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      cacheSize = Integer.parseInt(st.nextToken());

      if (cacheSize == 0) {
        break;
      }
      sb.append("Simulation ").append(turn++).append("\n");

      String commands = st.nextToken();
      for (int i = 0; i < commands.length(); i++) {
        char command = commands.charAt(i);

        if (command == '!') {
          Iterator<Character> it = values.descendingIterator();
          while (it.hasNext()) {
            sb.append(it.next());
          }
          sb.append("\n");
        } else {
          if (keys.containsKey(command)) {
            char eviction = keys.get(command);
            values.remove(eviction);
          } else if (values.size() == cacheSize) {
            char eviction = values.removeLast();
            keys.remove(eviction);
          }
          values.addFirst(command);
          keys.put(command, command);
        }
      }
    }
    System.out.println(sb);
  }
}
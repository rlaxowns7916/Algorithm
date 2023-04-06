package 백준.펠린드롬만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

  public static Map<Character, Node> map = new LinkedHashMap<>();

  public static void main(String[] args) throws IOException {
    boolean isPalindrome = true;
    StringBuilder sb = new StringBuilder();

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();

    for (int i = 0; i < input.length(); i++) {
      char chr = input.charAt(i);

      if (!map.containsKey(chr)) {
        map.put(chr, new Node(chr, 0));
      }
      map.get(chr).increase();
    }

    Character midChar = null;
    List<Node> nodes = map.values().stream().sorted().collect(Collectors.toList());

    for (Node node : nodes) {
      if (node.count % 2 == 1) {
        if (midChar != null) {
          isPalindrome = false;
          break;
        } else {
          midChar = node.chr;
        }
      }
      sb.append(String.valueOf(node.chr).repeat(Math.max(0, node.count / 2)));
    }
    if (isPalindrome) {
      String origin = sb.toString();
      String reverse = sb.reverse().toString();
      if (midChar != null) {
        System.out.println(origin + midChar + reverse);
      } else {
        System.out.println(origin + reverse);
      }
    } else {
      System.out.println("I'm Sorry Hansoo");
    }
  }
}

class Node implements Comparable<Node> {

  char chr;
  int count;

  public Node(char chr, int count) {
    this.chr = chr;
    this.count = count;
  }

  public void increase() {
    this.count++;
  }

  @Override
  public int compareTo(Node o) {
    return this.chr - o.chr;
  }
}

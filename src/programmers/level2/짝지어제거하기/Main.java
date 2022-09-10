package programmers.level2.짝지어제거하기;

import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    String input = "baabaa";
    Main main = new Main();

    System.out.println(main.solution(input));
  }

  public int solution(String s) {
    if (s.length() % 2 == 1) {
      return 0;
    }
    Stack<Character> st = new Stack<>();

    for (int i = 0; i < s.length(); i++) {
      Character chr = s.charAt(i);

      if (st.isEmpty()) {
        st.push(chr);
      } else {
        if (st.peek() == chr) {
          st.pop();
        } else {
          st.push(chr);
        }
      }
    }
    return st.size() == 0 ? 1 : 0;
  }
}

package 백준.후위표기식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> st = new Stack<>();
        String input = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (isCharacter(ch))
                sb.append(ch);
            else {
                int priority = getPriority(ch);
                if (priority == 3) {
                    if (ch == '(')
                        st.push(ch);
                    else {
                        while (!st.isEmpty()) {
                            char preCh = st.pop();
                            if (preCh != '(')
                                sb.append(preCh);
                            else
                                break;
                        }
                    }
                } else if (st.isEmpty() || getPriority(st.peek()) < priority)
                    st.push(ch);
                else {
                    while (!st.isEmpty()) {
                        int prePriority = getPriority(st.peek());
                        if (prePriority == 3 || prePriority < priority)
                            break;
                        sb.append(st.pop());
                    }
                    st.push(ch);
                }
            }
        }
        while (!st.isEmpty())
            sb.append(st.pop());
        System.out.println(sb);
    }

    public static boolean isCharacter(char ch) {
        return ('a' <= ch && ch <= 'z') || ('A' <= ch && ch <= 'Z');
    }

    public static int getPriority(char ch) {
        if (ch == '(' || ch == ')')
            return 3;
        else if (ch == '+' || ch == '-')
            return 1;
        else
            return 2;
    }
}

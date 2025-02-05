package programmers.level2.큰수만들기;


import java.util.Stack;

public class Solution {
    public String solution(String number, int k) {
        int popCount = 0;
        Stack<Character> st = new Stack<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < number.length(); i++) {
            char current = number.charAt(i);

            while (true) {
                 if (!st.isEmpty() && popCount < k && st.peek() < current) {
                    st.pop();
                    popCount++;
                 }else{
                    st.push(current);
                    break;
                }
            }
        }

        for(int i=popCount; i<=k;i++){
            st.pop();
        }

        while (!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
    }
}

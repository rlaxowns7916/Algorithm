package programmers.level2.택배상자;

import java.util.Stack;

public class Main {
    class Solution {
        public int solution(int[] order) {
            int answer = 0,len = order.length,now=0,belt=1;
            Stack<Integer> st = new Stack<>();

            while(now < len){
                if(order[now] == belt){
                    answer++;
                    belt++;
                    now++;
                }else if(order[now] < belt){
                    if(st.peek() == order[now]){
                        st.pop();
                        answer++;
                        now++;
                    } else{
                        break;
                    }
                }else{
                    st.push(belt++);
                }
            }
            return answer;
        }
    }
}

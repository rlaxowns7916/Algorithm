package 백준.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> result = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> nums = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        while (st.hasMoreTokens())
            nums.add(Integer.parseInt(st.nextToken()));

        for (int i = N - 1; i >= 0; i--) {
            int now = nums.get(i);
            while (true) {
                if (stack.isEmpty()) {
                    stack.push(now);
                    result.add(-1);
                    break;
                } else if (now < stack.peek()) {
                    result.add(stack.peek());
                    stack.push(now);
                    break;
                } else {
                    stack.pop();
                }
            }
        }
        for(int i=N-1;i>=0;i--){
            sb.append(result.get(i)).append(" ");
        }
        System.out.println(sb);
    }
}

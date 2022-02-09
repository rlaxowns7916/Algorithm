package 백준.탑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[] tops;

    public static void main(String[] args) throws IOException {
        Stack<Integer> valueStack = new Stack<>();
        Stack<Integer> indexStack = new Stack<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int value = 0;
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            boolean flag = false;
            value = Integer.parseInt(st.nextToken());
            while (!valueStack.isEmpty()) {
                if (valueStack.peek() > value) {
                    flag = true;
                    sb.append(indexStack.peek()).append(" ");
                    break;
                }
                valueStack.pop();
                indexStack.pop();
            }
            valueStack.add(value);
            indexStack.add(i);
            if (!flag)
                sb.append("0 ");
        }
        System.out.println(sb);
    }
}

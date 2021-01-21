package 백준.오큰수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0, j = 0;
        int[] arr = new int[N];

        for (i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        System.out.println(solve(arr));
    }

    /**
     * 스택에 아직 오큰수를 구하지 않은 숫자들의 Index를 집어넣는 방식
     */
    public static String solve(int[] arr) {
        Stack<Integer> st = new Stack();
        StringBuilder sb = new StringBuilder();
        int[] ans = new int[N];
        int i = 0;

        st.push(0);

        for (i = 1; i < N; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i])
                ans[st.pop()] = arr[i];
            st.push(i);
        }
        while (!st.isEmpty())
            ans[st.pop()] = -1;
        for (i = 0; i < N; i++)
            sb.append(ans[i] + " ");
        return sb.toString();
    }
}
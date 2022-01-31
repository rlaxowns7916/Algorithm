package 백준.부분합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, S = 0;
    public static int[] map;

    public static void main(String[] args) throws IOException {
        int left = 0, right = 0, len = Integer.MAX_VALUE;
        long sum = 0L;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());

        map = new int[N];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            map[i] = Integer.parseInt(st.nextToken());

        while (true) {
            if (sum >= S) {
                len = Math.min(len, right - left);
                sum -= map[left++];
            } else {
                if (right == N)
                    break;
                sum += map[right++];
            }
        }
        len = len == Integer.MAX_VALUE ? 0 : len;
        System.out.println(len);
    }
}

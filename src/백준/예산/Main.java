package 백준.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;

    public static void main(String[] args) throws IOException {
        long left = 0, right = 0, mid = 0, answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());

        long[] moneys = new long[N];
        for (int i = 0; i < N; i++)
            moneys[i] = Long.parseLong(st.nextToken());
        Arrays.sort(moneys);
        left = 1;
        right = moneys[N - 1];

        while (left <= right) {
            long budget = 0;
            mid = (left + right) / 2;

            for (long money : moneys) {
                if (money <= mid) {
                    budget += money;
                } else {
                    budget += mid;
                }
            }
            if (budget <= M) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else
                right = mid - 1;

        }
        System.out.println(answer);
    }
}
package 백준.예산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;

    public static void main(String[] args) throws IOException {
        int left = 0, right = 0, mid = 0, answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(br.readLine());

        int[] moneys = new int[N];
        for (int i = 0; i < N; i++)
            moneys[i] = Integer.parseInt(st.nextToken());

        left = moneys[0];
        right = moneys[N - 1];
        Arrays.sort(moneys);

        while (left <= right) {
            int budget = 0;
            mid = (left + right) / 2;

            for (int money : moneys) {
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

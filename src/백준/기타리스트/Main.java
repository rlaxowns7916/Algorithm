package 백준.기타리스트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, S = 0, M = 0;

    public static void main(String[] args) throws IOException {
        int max = -1;
        int[] volumes;
        boolean[][] dp;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 곡의 수
         */
        N = Integer.parseInt(st.nextToken());
        /**
         * 시작 시 볼륨
         */
        S = Integer.parseInt(st.nextToken());
        /**
         * 볼륨의 최대치
         */
        M = Integer.parseInt(st.nextToken());

        volumes = new int[N + 1];
        dp = new boolean[N + 1][M + 1];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++)
            volumes[i] = Integer.parseInt(st.nextToken());
        dp[0][S] = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j <= M; j++) {
                if (dp[i][j]) {
                    if (j - volumes[i] >= 0)
                        dp[i + 1][j - volumes[i]] = true;
                    if (j + volumes[i] <= M)
                        dp[i + 1][j + volumes[i]] = true;
                }
            }
        }
        for (int i = 0; i <= M; i++) {
            if (dp[N][i])
                max = Math.max(max, i);
        }
        System.out.println(max);
    }
}

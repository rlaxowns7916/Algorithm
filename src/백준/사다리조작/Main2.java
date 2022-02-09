package 백준.사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, M = 0, H = 0;
    public static int ans = Integer.MAX_VALUE;
    public static int[][] lines;

    public static void main(String[] args) throws IOException {
        int a = 0, b = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 세로선 개수
         */
        N = Integer.parseInt(st.nextToken());

        /**
         * 가로선 개수
         */
        M = Integer.parseInt(st.nextToken());

        /**
         * 가로선을 놓을 위치의 개수
         */
        H = Integer.parseInt(st.nextToken());

        lines = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());

            lines[a][b] = 1;
            lines[a][b + 1] = -1;
        }
        backTracking(1, 1, 0);
        if (ans == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(ans);
    }

    public static void backTracking(int x, int y, int count) {
        if (count > 3)
            return;
        if (isPromising())
            ans = Math.min(ans, count);
        else {
            int i = x, j = y;
            for (i = x; i <= H; i++) {
                for (; j < N; j++) {
                    if (lines[i][j] == 0 && lines[i][j + 1] != 1) {
                        lines[i][j] = 1;
                        lines[i][j + 1] = -1;
                        backTracking(i, j, count + 1);
                        lines[i][j] = lines[i][j + 1] = 0;
                    }
                }
                j = 1;
            }
        }
    }

    public static boolean isPromising() {
        for (int i = 1; i <= N; i++) {
            if (getArrival(i) != i)
                return false;
        }
        return true;
    }

    public static int getArrival(int idx) {
        int now = idx;
        for (int i = 1; i <= H; i++) {
            if (lines[i][now] == 1)
                now++;
            else if (lines[i][now] == -1)
                now--;
            else
                continue;
        }
        return now;
    }
}

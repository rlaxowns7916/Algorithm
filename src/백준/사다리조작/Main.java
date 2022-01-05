package 백준.사다리조작;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, H = 0, res = -1;
    public static int[][] visit;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int vertical, order;
        /**
         * 세로선
         */
        N = Integer.parseInt(st.nextToken());
        /**
         * 가로선
         */
        M = Integer.parseInt(st.nextToken());
        /**
         * 세로선 마다 연결 할 수 있는 가로선 수
         */
        H = Integer.parseInt(st.nextToken());
        visit = new int[H + 1][N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            order = Integer.parseInt(st.nextToken());
            vertical = Integer.parseInt(st.nextToken());
            visit[order][vertical] = 1;
            visit[order][vertical + 1] = -1;
        }
        for (int i = 0; i <= 3; i++)
            play(1, 1, 0, i);
        System.out.println(res);
    }

    public static void play(int x, int y, int depth, int count) {
        if (flag)
            return;
        else if (depth == count) {
            if (check()) {
                res = count;
                flag = true;
            }
        } else {
            int i=x,j=y;
            for ( ; i <= H; i++) {
                for ( ; j < N; j++) {
                    if (visit[i][j] == 0 && visit[i][j + 1] == 0) {
                        visit[i][j] = 1;
                        visit[i][j + 1] = -1;
                        play(i, j , depth + 1, count);
                        visit[i][j] = visit[i][j + 1] = 0;
                    }
                }
                j = 0;
            }
        }
    }

    public static boolean check() {
        int i = 0, j = 0, now = 0;
        for (i = 1; i <= N; i++) {
            now = i;
            for (j = 1; j <= H; j++) {
                if (visit[j][now] == 1)
                    now++;
                else if (visit[j][now] == -1)
                    now--;
            }
            if (now != i)
                return false;
        }
        return true;
    }
}
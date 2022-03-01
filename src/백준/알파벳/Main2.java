package 백준.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static int R = 0, C = 0, MAX = 0;
    public static char[][] map;
    public static boolean[] visit = new boolean[26];
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        for (int i = 0; i < R; i++) {
            String input = br.readLine();
            for (int j = 0; j < C; j++)
                map[i][j] = input.charAt(j);
        }
        visit[map[0][0] - 'A'] = true;
        backTracking(0, 0, 1);
        System.out.println(MAX);
    }

    public static void backTracking(int x, int y, int now) {
        int nextX = 0, nextY = 0;
        MAX = Math.max(MAX, now);
        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if (nextX >= 0 && nextX < R && nextY >= 0 && nextY < C) {
                char ch = map[nextX][nextY];
                int idx = ch - 'A';
                if (!visit[idx]) {
                    visit[idx] = true;
                    backTracking(nextX, nextY, now + 1);
                    visit[idx] = false;
                }
            }
        }
    }
}

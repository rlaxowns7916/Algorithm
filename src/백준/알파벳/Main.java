package 백준.알파벳;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, MAX = 0;
    public static char[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean[] visit = new boolean[26];

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (i = 0; i < N; i++) {
            String input = br.readLine();
            for (j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        visit[map[0][0] - 'A'] = true;
        solve(0, 0, visit, 1);
        System.out.println(MAX);
    }

    public static void solve(int p, int q, boolean[] visit, int count) {
        int nx = 0, ny = 0;
        MAX = Math.max(MAX, count);

        for (int i = 0; i < 4; i++) {
            nx = p + dx[i];
            ny = q + dy[i];

            if (isPromising(nx, ny, visit)) {
                visit[map[nx][ny] - 'A'] = true;
                solve(nx, ny, visit, count + 1);
                visit[map[nx][ny] - 'A'] = false;
            }

        }

    }
    public static boolean isPromising(int i, int j, boolean[] visit) {
        return i >= 0 && i < N && j >= 0 && j < M && !visit[map[i][j] - 'A'];
    }
}
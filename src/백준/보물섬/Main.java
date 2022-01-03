package 백준.보물섬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int N = 0, M = 0, MAX = 0;
    public static char[][] map;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];


        for (i = 0; i < N; i++) {
            String input = br.readLine();
            for (j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (map[i][j] == 'L')
                    bfs(i, j);
            }
        }
        System.out.println(MAX);
    }

    public static void bfs(int p, int q) {
        int x = 0, y = 0, nx = 0, ny = 0, i = 0, j = 0, cnt = 0, qSize = 0;
        Queue<Point> queue = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        queue.add(new Point(p, q));
        visit[p][q] = true;

        while (!queue.isEmpty()) {
            qSize = queue.size();

            for (j = 0; j < qSize; j++) {
                Point now = queue.poll();
                x = now.x;
                y = now.y;

                for (i = 0; i < 4; i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visit[nx][ny] && map[nx][ny] == 'L') {
                        queue.add(new Point(nx, ny));
                        visit[nx][ny] = true;
                    }
                }
            }
            cnt++;
        }
        MAX=Math.max(MAX, cnt);
    }
}

class Point {
    int x = 0;
    int y = 0;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

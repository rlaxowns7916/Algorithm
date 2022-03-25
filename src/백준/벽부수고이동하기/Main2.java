package 백준.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, M = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x = 0;
        int y = 0;
        int isBroken;

        public Point(int x, int y, int isBroken) {
            this.x = x;
            this.y = y;
            this.isBroken = isBroken;
        }
    }

    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M + 1];

        for (int i = 1; i <= N; i++) {
            String input = br.readLine();
            for (int j = 1; j <= M; j++)
                map[i][j] = input.charAt(j - 1) - '0';
        }
        result = bfs();
        if (result == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(result);
    }

    public static int bfs() {
        int nowX = 0, nowY = 0, nextX = 0, nextY = 0, min = Integer.MAX_VALUE;
        int nowBroken = 0;
        int[][][] dist = new int[2][N + 1][M + 1];
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(1, 1, 0));
        dist[0][1][1] = 1;

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            nowX = now.x;
            nowY = now.y;
            nowBroken = now.isBroken;

            if (nowX == N && nowY == M) {
                min = dist[nowBroken][nowX][nowY];
                break;
            }

            for (int i = 0; i < 4; i++) {
                nextX = nowX + dx[i];
                nextY = nowY + dy[i];

                if (nextX > 0 && nextX <= N && nextY > 0 && nextY <= M) {
                    /**
                     * 이미 뿌심
                     */
                    if (nowBroken == 1) {
                        if (map[nextX][nextY] == 0) {
                            int nextStep = dist[1][nowX][nowY] + 1;
                            if (dist[1][nextX][nextY] == 0 || dist[1][nextX][nextY] > nextStep) {
                                dist[1][nextX][nextY] = nextStep;
                                queue.add(new Point(nextX, nextY, 1));
                            }
                        }
                    }
                    /**
                     * 아직 안뿌심
                     */
                    else {
                        int nextStep = dist[0][nowX][nowY] + 1;
                        if (map[nextX][nextY] == 0) {
                            if (dist[0][nextX][nextY] == 0 || dist[0][nextX][nextY] > nextStep) {
                                dist[0][nextX][nextY] = nextStep;
                                queue.add(new Point(nextX, nextY, 0));
                            }
                        } else {
                            if (dist[1][nextX][nextY] == 0 || dist[1][nextX][nextY] > nextStep) {
                                dist[1][nextX][nextY] = nextStep;
                                queue.add(new Point(nextX, nextY, 1));
                            }
                        }
                    }
                }
            }
        }
        return min;
    }
}

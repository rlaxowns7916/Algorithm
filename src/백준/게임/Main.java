package 백준.게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int INF = 25000;

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int x1 = 0, y1 = 0, x2 = 0, y2 = 0;
        int startX = 0, startY = 0, endX = 0, endY = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        map = new int[501][501];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            startX = Math.min(x1, x2);
            startY = Math.min(y1, y2);

            endX = Math.max(x1, x2);
            endY = Math.max(y1, y2);
            /**
             * 위험한 구역 2
             */
            for (int j = startX; j <= endX; j++) {
                for (int k = startY; k <= endY; k++) {
                    map[j][k] = 2;
                }
            }
        }
        M = Integer.parseInt(br.readLine());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());

            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());

            startX = Math.min(x1, x2);
            startY = Math.min(y1, y2);

            endX = Math.max(x1, x2);
            endY = Math.max(y1, y2);
            /**
             * 죽음의 구역 3
             */
            for (int j = startX; j <= endX; j++) {
                for (int k = startY; k <= endY; k++) {
                    map[j][k] = 3;
                }
            }
        }
        System.out.println(bfs());
    }

    public static int bfs() {
        int answer = -1;
        int nowX = 0, nowY = 0, nextX = 0, nextY = 0;
        int[][] dist = new int[501][501];
        Deque<Point> deque = new LinkedList<>();
        for (int i = 0; i < 501; i++) {
            Arrays.fill(dist[i], INF);
        }
        dist[0][0] = 0;
        deque.addFirst(new Point(0, 0));
        while (!deque.isEmpty()) {
            Point now = deque.poll();

            nowX = now.x;
            nowY = now.y;

            if (nowX == 500 && nowY == 500) {
                answer = dist[500][500];
                break;
            }

            for (int i = 0; i < 4; i++) {
                nextX = nowX + dx[i];
                nextY = nowY + dy[i];

                if (nextX >= 0 && nextX <= 500 && nextY >= 0 && nextY <= 500 && map[nextX][nextY] != 3) {
                    if (map[nextX][nextY] == 0) {
                        if (dist[nowX][nowY] < dist[nextX][nextY]) {
                            deque.addFirst(new Point(nextX, nextY));
                            dist[nextX][nextY] = dist[nowX][nowY];
                        }
                    } else {
                        if (dist[nowX][nowY] + 1 < dist[nextX][nextY]) {
                            deque.addLast(new Point(nextX, nextY));
                            dist[nextX][nextY] = dist[nowX][nowY] + 1;
                        }
                    }
                }
            }
        }
        return answer;
    }
}

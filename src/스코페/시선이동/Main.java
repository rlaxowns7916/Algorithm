package 스코페.시선이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, MAX = 9999999;
    public static char[][] Map;
    public static int[][] Weight;
    public static int[] dx = {0, 1, 0};
    public static int[] dy = {1, 0, -1};

    public static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Point> queue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        Map = new char[N][M];
        Weight = new int[N][M];


        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            Arrays.fill(Weight[i], MAX);
            for (int j = 0; j < M; j++) {
                Map[i][j] = str.charAt(j);
                if (Map[i][j] == 'c') {
                    queue.add(new Point(i, j));
                    Weight[i][j] = 0;
                }
            }
        }
        System.out.println(BFS());
    }

    public static int BFS() {
        int x = 0, y = 0, nx = 0, ny = 0, min = Integer.MAX_VALUE;
        Point temp;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            x = temp.x;
            y = temp.y;

            for (int i = 0; i < 3; i++) {
                nx = x + dx[i];
                ny = y + dy[i];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && Map[nx][ny] == '.') {
                    if (i == 1) {
                        if (Weight[nx][ny] > Weight[x][y]) {
                            Weight[nx][ny] = Weight[x][y];
                            queue.add(new Point(nx, ny));
                        }
                    } else {
                        if (Weight[nx][ny] > Weight[x][y] + 1) {
                            Weight[nx][ny] = Weight[x][y] + 1;
                            queue.add(new Point(nx, ny));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < M; i++)
            min = Math.min(min, Weight[N - 1][i]);

        return min == MAX ? -1 : min;
    }
}

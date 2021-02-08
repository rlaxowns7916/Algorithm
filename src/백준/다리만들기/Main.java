package 백준.다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Queue<Point> queue = new LinkedList();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, val = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                val = Integer.parseInt(st.nextToken());
                if (val == 1)
                    queue.add(new Point(i, j));
                map[i][j] = val;
            }
        }
        System.out.println(BFS());
    }

    public static void checkTerritory() {
        int count = 2, i = 0, j = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (map[i][j] == 1) {
                    DFS(count, i, j);
                    count++;
                }
            }
        }
    }

    public static int BFS() {
        int count = 99999, i = 0, nx = 0, ny = 0, size = 0,weight=0;
        int[][] weights = new int[N][N];
        for (i = 0; i < N; i++)
            Arrays.fill(weights[i], 99999);
        checkTerritory();

        Point temp = queue.peek();
        weights[temp.x][temp.y] = 0;

        while (!queue.isEmpty()) {
            size = queue.size();
            for (; size > 0; size--) {
                temp = queue.poll();
                for (i = 0; i < 4; i++) {
                    nx = temp.x + dx[i];
                    ny = temp.y + dy[i];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (map[nx][ny] == 0) {
                            map[nx][ny] = map[temp.x][temp.y];
                            weights[nx][ny] = weight + 1;
                            queue.add(new Point(nx, ny));
                        } else if (map[nx][ny] != map[temp.x][temp.y])
                            count = Math.min(count, weight + weights[nx][ny]);
                    }
                }
            }
            weight++;
        }
        return count;
    }

    public static void DFS(int tNum, int x, int y) {
        int nx = 0, ny = 0, i = 0;
        map[x][y] = tNum;
        for (i = 0; i < 4; i++) {
            nx = x + dx[i];
            ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N && map[nx][ny] == 1) {
                map[nx][ny] = tNum;
                DFS(tNum, nx, ny);
            }
        }
    }
}

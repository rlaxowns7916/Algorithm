package 백준.인구이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, L = 0, R = 0, day = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int i = 0, j = 0;
        boolean[][] visit;
        int[][] copyMap;
        while (true) {
            boolean flag = false;
            visit = new boolean[N][N];
            copyMap = mapCopy();
            for (i = 0; i < N; i++) {
                for (j = 0; j < N; j++) {
                    if (!visit[i][j]){
                        if(bfs(i, j, copyMap, visit))
                            flag = true;
                    }
                }
            }
            if (flag)
                day++;
            else
                break;
        }
        return day;
    }

    public static boolean bfs(int i, int j, int[][] copyMap, boolean[][] visit) {
        int x = 0, y = 0, nextX = 0, nextY = 0, diff = 0, sum = 0, populationAfterMove = 0;
        Queue<Point> queue = new LinkedList<>();
        ArrayList<Point> sameUnion = new ArrayList<>();
        visit[i][j] = true;
        queue.add(new Point(i, j));
        sameUnion.add(queue.peek());
        sum = copyMap[i][j];

        while (!queue.isEmpty()) {
            Point now = queue.poll();
            x = now.x;
            y = now.y;
            for (int dir = 0; dir < 4; dir++) {
                nextX = x + dx[dir];
                nextY = y + dy[dir];
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < N && !visit[nextX][nextY]) {
                    diff = Math.abs(copyMap[nextX][nextY] - copyMap[now.x][now.y]);
                    if (diff >= L && diff <= R) {
                        Point next = new Point(nextX, nextY);
                        queue.add(next);
                        sameUnion.add(next);
                        sum += copyMap[nextX][nextY];
                        visit[nextX][nextY] = true;
                    }
                }
            }
        }
        populationAfterMove = sum / sameUnion.size();
        for (Point point : sameUnion)
            map[point.x][point.y] = populationAfterMove;

        return sameUnion.size() > 1;
    }

    public static int[][] mapCopy() {
        int[][] copyMap = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                copyMap[i][j] = map[i][j];
            }
        }
        return copyMap;
    }
}

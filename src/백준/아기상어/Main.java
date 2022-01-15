package 백준.아기상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 0, 1};
    public static int[] dy = {0, -1, 1, 0};
    public static Shark shark;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(new Point(i, j));
                    map[i][j] = 0;
                }
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int count = 0, res = 0;

        while (true) {
            res = search();
            if (res == -1)
                return count;
            count += res;
        }
    }

    public static int search() {
        int x = 0, y = 0;
        int nextX = 0, nextY = 0;
        int size = 0, turn = 0;
        boolean[][] visit = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        Point candidate = null;

        Point now = shark.point;
        queue.add(now);
        visit[now.x][now.y] = true;

        while (!queue.isEmpty()) {
            size = queue.size();
            turn++;
            for (int i = 0; i < size; i++) {
                now = queue.poll();
                x = now.x;
                y = now.y;

                for (int j = 0; j < 4; j++) {
                    nextX = x + dx[j];
                    nextY = y + dy[j];

                    if (nextX >= 0 && nextY >= 0 && nextX < N && nextY < N && !visit[nextX][nextY] && map[nextX][nextY] <= shark.level) {
                        Point next = new Point(nextX, nextY);
                        if (map[nextX][nextY] != 0 && map[nextX][nextY] < shark.level && isPromising(next, candidate))
                            candidate = next;
                        visit[nextX][nextY] = true;
                        queue.add(next);
                    }
                }
            }
            if (candidate != null)
                break;
        }

        if (candidate != null) {
            shark.point = candidate;
            shark.eat();
            map[candidate.x][candidate.y] = 0;
            return turn;
        }
        return -1;
    }

    public static boolean isPromising(Point next, Point candidate) {
        if (candidate == null)
            return true;
        else {
            if (next.x < candidate.x)
                return true;
            else return next.x == candidate.x && next.y < candidate.y;
        }
    }

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Shark {
        Point point;
        int level;
        int eatCount;

        public void eat() {
            eatCount++;
            if (eatCount == level) {
                level++;
                eatCount = 0;
            }
        }

        public Shark(Point point) {
            this.point = point;
            level = 2;
            eatCount = 0;
        }
    }
}
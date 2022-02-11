package 백준.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, M = 0, remainCount = 0, result = Integer.MAX_VALUE;
    public static int[][] map;
    public static int[][][] dx = {
            {}, {{-1}, {0}, {1}, {0}}, {{-1, 1}, {0, 0}}, {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}, {{0, 1, 0}, {-1, 1, 0}, {-1, 0, 0}, {-1, 0, 1}}, {{-1, 0, 1, 0}}
    };
    public static int[][][] dy = {
            {}, {{0}, {1}, {0}, {-1}}, {{0, 0}, {-1, 1}}, {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}, {{1, 0, -1}, {0, 0, -1}, {0, 1, -1}, {0, 1, 0}}, {{0, 1, 0, -1}}
    };
    public static int[] dirSize = {0, 4, 2, 4, 4, 1};
    public static ArrayList<Point> cctvs = new ArrayList<>();

    static class CCTV {
        int idx;
        int dir;
        Point point;

        public CCTV(int idx, int dir, Point point) {
            this.idx = idx;
            this.dir = dir;
            this.point = point;
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

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        remainCount = N * M;
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (0 < map[i][j] && map[i][j] < 6) {
                    cctvs.add(new Point(i, j));
                }
                if (map[i][j] > 0)
                    remainCount--;
            }

        }
        solve(0, new ArrayList<>());
        System.out.println(result);
    }

    public static void solve(int count, ArrayList<CCTV> cctvWithDirection) {
        if (count == cctvs.size()) {
            result = Math.min(result, monitoring(cctvWithDirection));
        } else {
            Point now = cctvs.get(count);
            int cctvIdx = map[now.x][now.y];
            for (int i = 0; i < dirSize[cctvIdx]; i++) {
                ArrayList<CCTV> newCCTVWithDirection = new ArrayList<>(cctvWithDirection);
                newCCTVWithDirection.add(new CCTV(cctvIdx, i, now));
                solve(count + 1, newCCTVWithDirection);
            }
        }
    }

    public static int monitoring(ArrayList<CCTV> cctvWithDirection) {
        int originX = 0, originY = 0;
        int nowX = 0, nowY = 0, num = 0;
        int nextX = 0, nextY = 0;
        boolean[][] visit = new boolean[N][M];

        for (CCTV now : cctvWithDirection) {
            originX = now.point.x;
            originY = now.point.y;
            for (int j = 0; j < dx[now.idx][now.dir].length; j++) {
                nowX = originX;
                nowY = originY;
                while (true) {
                    nextX = nowX + dx[now.idx][now.dir][j];
                    nextY = nowY + dy[now.idx][now.dir][j];

                    if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M || map[nextX][nextY] == 6)
                        break;
                    if (!visit[nextX][nextY] && map[nextX][nextY] == 0)
                        num++;
                    visit[nextX][nextY] = true;
                    nowX = nextX;
                    nowY = nextY;
                }
            }
        }
        return remainCount - num;
    }
}

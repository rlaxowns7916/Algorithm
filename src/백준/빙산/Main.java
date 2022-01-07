package 백준.빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[][] map;
    public static int[] xDirection = {-1, 0, 1, 0};
    public static int[] yDirection = {0, 1, 0, -1};
    public static Queue<Point> ices = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0)
                    ices.add(new Point(i, j));
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int level = 0;
        while (!ices.isEmpty() && !isSeperated()) {
            level++;
            melting();
        }
        if (ices.isEmpty())
            return 0;
        else
            return level;
    }

    public static int[][] mapCopy() {
        int[][] copiedMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++)
                copiedMap[i][j] = map[i][j];
        }
        return copiedMap;
    }

    public static boolean isSeperated() {
        int iceCount = 0;
        int directionIndex = 0;
        int nextX = 0, nextY = 0;
        int x = 0, y = 0;
        Queue<Point> searchingIce = new LinkedList<>();
        boolean[][] visit = new boolean[N][M];

        Point currentIce = ices.peek();
        searchingIce.add(currentIce);
        visit[currentIce.x][currentIce.y] = true;

        while (!searchingIce.isEmpty()) {
            iceCount++;
            currentIce = searchingIce.poll();
            x = currentIce.x;
            y = currentIce.y;

            for (directionIndex = 0; directionIndex < 4; directionIndex++) {
                nextX = x + xDirection[directionIndex];
                nextY = y + yDirection[directionIndex];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] > 0 && !visit[nextX][nextY]) {
                    visit[nextX][nextY] = true;
                    searchingIce.add(new Point(nextX, nextY));
                }
            }
        }
        return iceCount != ices.size();
    }

    public static void melting() {
        int i = 0;
        int size = 0;
        int directionIndex = 0;
        int nextX = 0, nextY = 0;
        int x = 0, y = 0;
        int[][] copiedMap = mapCopy();
        Point ice;
        size = ices.size();
        for (i = 0; i < size; i++) {
            ice = ices.poll();
            x = ice.x;
            y = ice.y;

            for (directionIndex = 0; directionIndex < 4; directionIndex++) {
                nextX = x + xDirection[directionIndex];
                nextY = y + yDirection[directionIndex];

                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M && map[nextX][nextY] == 0)
                    copiedMap[x][y]--;
                if (copiedMap[x][y] == 0)
                    break;
            }
            if (copiedMap[x][y] > 0)
                ices.add(new Point(x, y));
        }
        map = copiedMap;
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

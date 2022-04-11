package 백준.스토쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main3 {
    public static StringBuilder sb = new StringBuilder();
    public static boolean flag = false;
    public static int N = 9;
    public static int[][] map = new int[N][N];
    public static List<Point> position = new ArrayList<>();

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

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    position.add(new Point(i, j));
            }
        }
        solve(0);
        System.out.println(sb);
    }

    public static void solve(int N) {
        if (flag)
            return;
        else if (N == position.size()) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(map[i][j]).append(" ");
                }
                sb.append("\n");
            }
            flag = true;
        } else {
            Point now = position.get(N);
            for (int i = 1; i <= 9; i++) {
                if (isPromising(now.x, now.y, i)) {
                    map[now.x][now.y] = i;
                    solve(N + 1);
                    map[now.x][now.y] = 0;
                }
            }
        }
    }

    public static boolean isPromising(int i, int j, int value) {
        return isRowPromising(i, value) && isColPromising(j, value) && isPartPromising(i, j, value);
    }

    public static boolean isRowPromising(int idx, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[idx][i] == value)
                return false;
        }
        return true;
    }

    public static boolean isColPromising(int idx, int value) {
        for (int i = 0; i < 9; i++) {
            if (map[i][idx] == value)
                return false;
        }
        return true;
    }

    public static boolean isPartPromising(int x, int y, int value) {
        int partX = x / 3, partY = y / 3, startX = partX * 3, startY = partY * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }
        return true;
    }
}

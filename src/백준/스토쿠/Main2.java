package 백준.스토쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 9;
    public static boolean flag = false;
    public static int[][] map = new int[N][N];
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0)
                    list.add(new Point(i, j));
            }
        }
        solve(0);
        System.out.println(sb);
    }

    public static void solve(int depth) {
        if (flag)
            return;
        else {
            if (depth == list.size()) {
                for (int i = 0; i < N; i++) {
                    for (int j = 0; j < N; j++)
                        sb.append(map[i][j]).append(" ");
                    sb.append("\n");
                }
                flag = true;
            } else {
                Point now = list.get(depth);
                for (int i = 1; i <= N; i++) {
                    if (isRowPromising(now.y, i) && isColPromising(now.x, i) && isPartialPromising(now.x, now.y, i)) {
                        map[now.x][now.y] = i;
                        solve(depth + 1);
                        map[now.x][now.y] = 0;
                    }
                }

            }
        }
    }

    public static boolean isPartialPromising(int nRow, int nCol, int value) {
        int i = 0, j = 0, x = (nRow / 3) * 3, y = (nCol / 3) * 3;

        for (i = x; i < x + 3; i++) {
            for (j = y; j < y + 3; j++) {
                if (map[i][j] == value)
                    return false;
            }
        }
        return true;
    }

    public static boolean isRowPromising(int nCol, int value) {
        for (int i = 0; i < N; i++) {
            if (map[i][nCol] == value)
                return false;
        }
        return true;
    }

    public static boolean isColPromising(int nRow, int value) {
        for (int i = 0; i < N; i++) {
            if (map[nRow][i] == value)
                return false;
        }
        return true;
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

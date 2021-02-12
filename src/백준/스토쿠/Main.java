package 백준.스토쿠;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static int N = 9;
    public static boolean flag = true;
    public static int[] row = new int[N + 1];
    public static int[] col = new int[N + 1];
    public static int[] piece = new int[N + 1];
    public static int[][] map = new int[N + 1][N + 1];
    public static StringBuilder sb = new StringBuilder();
    public static ArrayList<Point> empty = new ArrayList();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, val = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 1; j <= N; j++) {
                val = Integer.parseInt(st.nextToken());
                if (val == 0)
                    empty.add(new Point(i, j));
                else {
                    row[i] |= 1 << val;
                    col[j] |= 1 << val;
                    piece[getPieceIndex(i, j)] |= 1 << val;
                    map[i][j] = val;
                }
            }
        }
        backTracking(0);
        System.out.println(sb.toString());
    }

    public static boolean promising(int index, int x, int y) {
        return (row[x] & 1 << index) == 0 && (col[y] & 1 << index) == 0 && (piece[getPieceIndex(x, y)] & 1 << index) == 0;
    }

    public static void backTracking(int depth) {
        int i = 0, j = 0, x = 0, y = 0;
        if(!flag)
            return;
        if (depth == empty.size()) {
            for (i = 1; i <= N; i++) {
                for (j = 1; j <= N; j++)
                    sb.append(map[i][j]).append(" ");
                sb.append("\n");
            }
            flag = false;
        } else {
            Point target = empty.get(depth);
            x = target.x;
            y = target.y;
            for (i = 1; i <= N; i++) {
                if (promising(i, x, y)) {
                    row[x] |= 1 << i;
                    col[y] |= 1 << i;
                    piece[getPieceIndex(x, y)] |= 1 << i;
                    map[x][y] = i;
                    backTracking(depth + 1);
                    row[x] &= ~(1 << i);
                    col[y] &= ~(1 << i);
                    piece[getPieceIndex(x, y)] &= ~(1 << i);
                }
            }
        }

    }

    public static int getPieceIndex(int x, int y) {
        int rx = (x - 1) / 3, ry = (y - 1) / 3;
        if (rx == 0) {
            if (ry == 0)
                return 1;
            else if (ry == 1)
                return 2;
            else
                return 3;
        } else if (rx == 1) {
            if (ry == 0)
                return 4;
            else if (ry == 1)
                return 5;
            else
                return 6;
        } else {
            if (ry == 0)
                return 7;
            else if (ry == 1)
                return 8;
            else
                return 9;
        }
    }
}

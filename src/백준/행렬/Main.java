package 백준.행렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, size = 2;
    public static boolean[][] check;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0, j = 0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N][M];
        int[][] src = new int[N][M];

        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < M; j++) {
                src[i][j] = str.charAt(j) - '0';
            }
        }
        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < M; j++) {
                if (str.charAt(j) - '0' == src[i][j])
                    check[i][j] = true;
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int count = 0, i = 0, j = 0;
        for (i = 0; i + size < N; i++) {
            for (j = 0; j + size < M; j++) {
                if (!check[i][j]) {
                    count++;
                    reverse(i, j);
                }
            }
        }
        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (!check[i][j])
                    return -1;
            }
        }
        return count;
    }

    public static void reverse(int x, int y) {
        for (int i = x; i <= x + size; i++) {
            for (int j = y; j <= y + size; j++) {
                check[i][j] = !check[i][j];
            }
        }
    }
}

package 백준.플로이드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, E = 0;
    public static long INF = (long)100000*100000+1;
    public static long[][] Map;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, start = 0, end = 0, dist = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        E = Integer.parseInt(br.readLine());


        Map = new long[N + 1][N + 1];
        for (i = 1; i <= N; i++) {
            Arrays.fill(Map[i], INF);
            Map[i][i] = 0;
        }

        for (i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            dist = Integer.parseInt(st.nextToken());

            Map[start][end] = Math.min(Map[start][end], dist);
        }
        func();
        System.out.println(print());
    }

    public static String print() {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++) {
                if (Map[i][j] != INF)
                    sb.append(Map[i][j]).append(" ");
                else
                    sb.append(0).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void func() {
        int i = 0, j = 0, k = 0;
        for (k = 1; k <= N; k++) {
            for (i = 1; i <= N; i++) {
                for (j = 1; j <= N; j++)
                    Map[i][j] = Math.min(Map[i][j], Map[i][k] + Map[k][j]);
            }
        }
    }
}
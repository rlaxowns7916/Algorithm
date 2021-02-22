package 백준.역사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int INF = 999999;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken()), s = 0, i = 0, first = 0, second = 0;
        int[][] map = new int[n + 1][n + 1];

        for (i = 1; i <= n; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            map[first][second] = 1;
        }
        floyd(map, n);
        s = Integer.parseInt(br.readLine());
        for (i = 0; i < s; i++) {
            st = new StringTokenizer(br.readLine());
            first = Integer.parseInt(st.nextToken());
            second = Integer.parseInt(st.nextToken());

            if (map[first][second] != INF)
                sb.append(-1).append("\n");
            else if (map[second][first] != INF)
                sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void floyd(int[][] map, int n) {
        int i = 0, j = 0, k = 0;
        for (k = 1; k <= n; k++) {
            for (i = 1; i <= n; i++) {
                for (j = 1; j <= n; j++) {
                    if (i == j || map[i][k] == INF || map[k][j] == INF)
                        continue;
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }
    }
}

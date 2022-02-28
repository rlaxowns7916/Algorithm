package 백준.키순서;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int INF = 999999;
    public static int N = 0, M = 0;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        int cnt = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(map[i], INF);
            map[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken()) - 1][Integer.parseInt(st.nextToken()) - 1] = 1;
        }
        System.out.println(floyd());
    }

    public static int floyd() {
        int ans = 0;
        for (int mid = 0; mid < N; mid++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (map[i][j] > map[i][mid] + map[mid][j])
                        map[i][j] = map[i][mid] + map[mid][j];
                }
            }
        }
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (i == j)
                    continue;
                if (map[i][j] != INF || map[j][i] != INF)
                    count++;
            }
            if (count == N-1)
                ans++;
        }
        return ans;
    }
}

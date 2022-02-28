package 백준.운동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int V = 0, E = 0;
    public static int INF = 9999999;
    public static int[][] map;

    public static void main(String[] args) throws IOException {
        int result = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        map = new int[V + 1][V + 1];
        for (int i = 1; i <= V; i++) {
            Arrays.fill(map[i], INF);
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            map[from][to] = weight;
        }
        floyd();
        result = findMinCycle();

        result = result >= INF ? -1 : result;
        System.out.println(result);
    }

    public static void floyd() {
        for (int mid = 1; mid <= V; mid++) {
            for (int i = 1; i <= V; i++) {
                for (int j = 1; j <= V; j++) {
                    if (map[i][j] > map[i][mid] + map[mid][j])
                        map[i][j] = map[i][mid] + map[mid][j];
                }
            }
        }
    }

    public static int findMinCycle() {
        int min = INF;
        for (int i = 1; i <= V; i++) {
            min = Math.min(min, map[i][i]);
        }
        return min;
    }
}

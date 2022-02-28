package 기본;

/**
 * 플로이드는 O(N^3) 인 알고리즘으로, 보통 N <= 500 인경우에 사용가능하다.
 * 주요사용처
 * 1. 모든 경로를 파악 할 때
 * 2. 모든 대소비교가 필요 할 때
 */

public class Floyd {
    static int INF = 999999;

    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        int[][] map = new int[][]{{0, 5, INF, 8}, {7, 0, 9, INF}, {2, INF, 0, 4}, {INF, INF, 3, 0}};
        int[][] dist = floyd(map);

        for (int[] row : dist) {
            for (int col : row) {
                sb.append(col).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static int[][] floyd(int[][] map) {
        int n = map.length;
        int[][] dist = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                dist[i][j] = map[i][j];
        }

        for (int mid = 0; mid < n; mid++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (i == j)
                        continue;
                    if (dist[i][j] > dist[i][mid] + dist[mid][j])
                        dist[i][j] = dist[i][mid] + dist[mid][j];
                }
            }
        }
        return dist;
    }
}

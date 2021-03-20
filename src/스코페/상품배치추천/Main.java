package 스코페.상품배치추천;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N = 0;
    public static int[][] Map;
    public static int[] count;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        Map = new int[N][N];
        count = new int[N];
        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < N; j++)
                Map[i][j] = str.charAt(j) - '0';
        }

        sb.append("total: ").append(func()).append("\n");
        for (i = 0; i < N; i++) {
            if (count[i] != 0)
                sb.append("size[").append(i + 1).append("]: ").append(count[i]).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int func() {
        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (Map[i][j] == 1) {
                    for (int k = 0; k < N; k++) {
                        if (i + k < N && j + k < N) {
                            if (calculate(i, j, k))
                                ans += 1;
                        }
                    }
                }
            }
        }
        return ans;
    }

    public static boolean calculate(int start, int end, int size) {
        for (int i = start; i <= start + size; i++) {
            for (int j = end; j <= end + size; j++) {
                if (Map[i][j] == 0)
                    return false;
            }
        }
        count[size]++;
        return true;
    }
}

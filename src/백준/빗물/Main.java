package 백준.빗물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[M];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < M; i++)
            map[i] = Integer.parseInt(st.nextToken());
        System.out.println(solve());
    }

    public static int solve() {
        int sum = 0, standard = 0;
        int i = 0, j = 0;

        for (i = 0; i < M; i++) {
            int left = -1, right = -1;
            for (j = i - 1; j >= 0; j--) {
                if (left < map[j])
                    left = map[j];
            }
            for (j = i + 1; j < M; j++) {
                if (right < map[j])
                    right = map[j];
            }
            if (left != -1 && right != -1) {
                standard = Math.min(left, right);
                int diff = standard - map[i];
                if (diff > 0)
                    sum += diff;
            }
        }
        return sum;
    }
}

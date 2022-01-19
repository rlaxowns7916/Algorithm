package 백준.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static Item[] items;
    public static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        items = new Item[N];
        dp = new int[N][M + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            items[i] = new Item(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(items);
        System.out.println(solve());
    }

    public static int solve() {
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= M; j++) {
                if (i > 0) {
                    if (j >= items[i].weight)
                        dp[i][j] = Math.max(dp[i - 1][j - items[i].weight] + items[i].value, dp[i - 1][j]);
                    else
                        dp[i][j] = dp[i - 1][j];
                } else {
                    if (j >= items[i].weight)
                        dp[i][j] = items[i].value;
                    else
                        dp[i][j] = 0;
                }
            }
        }
        return dp[N - 1][M];
    }

    static class Item implements Comparable<Item> {
        int weight = 0;
        int value = 0;

        public Item(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Item o) {
            return this.weight - o.weight;
        }
    }
}

package 백준.평범한배낭;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main2 {
    static class Item implements Comparable<Item> {
        int value;
        int weight;

        public Item(int value,int weight){
            this.value = value;
            this.weight = weight;
        }

        @Override
        public int compareTo(Item o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        /**
         * N: 물품의 수
         * K: 버틸 수 있는 무게
         *
         * W: 물건의 무게
         * V: 물건의 가치
         */
        int N = 0, K = 0, W = 0, V = 0;


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        Item[] items = new Item[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            W = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            items[i] = new Item(V,W);
        }
        Arrays.sort(items);
        System.out.println(solve(N, K, items));
    }

    public static int solve(int N, int K, Item[] items) {
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= K; j++) {
                if (items[i - 1].weight <= j)
                    dp[i][j] = Math.max(dp[i-1][j], dp[i - 1][j - items[i-1].weight] + items[i-1].value);
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[N][K];
    }
}

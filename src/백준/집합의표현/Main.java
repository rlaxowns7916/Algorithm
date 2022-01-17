package 백준.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int operand = 0, set1 = 0, set2 = 0;


        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        init();

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            operand = Integer.parseInt(st.nextToken());
            set1 = Integer.parseInt(st.nextToken());
            set2 = Integer.parseInt(st.nextToken());

            if (operand == 0) {
                union(set1, set2);
            } else {
                if (find(set1) == find(set2))
                    sb.append("YES");
                else
                    sb.append("NO");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void init() {
        parent = new int[N + 1];
        rank = new int[N + 1];
        for (int i = 0; i <= N; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x != y) {
            if (rank[x] < rank[y])
                parent[x] = y;
            else
                parent[y] = x;
            if (rank[x] == rank[y])
                rank[x]++;
        }
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
}

package 백준.집합의표현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {
    public static int N = 0, M = 0;
    public static int[] parent;

    public static void main(String[] args) throws IOException {
        int operator = 0, op1 = 0, op2 = 0;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        parent = new int[N + 1];

        for (int i = 1; i <= N; i++)
            parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            operator = Integer.parseInt(st.nextToken());
            op1 = Integer.parseInt(st.nextToken());
            op2 = Integer.parseInt(st.nextToken());

            if (operator == 0) {
                union(op1, op2);
            } else {
                if (find(op1) == find(op2))
                    sb.append("YES").append("\n");
                else
                    sb.append("NO").append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x < y)
            parent[y] = x;
        else
            parent[x] = y;
    }

    public static int find(int x) {
        if (x == parent[x])
            return x;
        else
            return parent[x] = find(parent[x]);
    }
}
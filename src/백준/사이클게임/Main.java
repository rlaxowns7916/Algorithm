package 백준.사이클게임;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) throws IOException {
        boolean flag = false;
        int i = 0, num1 = 0, num2 = 0, count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
        for (i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            num1 = Integer.parseInt(st.nextToken());
            num2 = Integer.parseInt(st.nextToken());
            count++;
            if (find(num1) != find(num2))
                union(num1, num2);
            else {
                flag = true;
                break;
            }
        }
        if (flag)
            System.out.println(count);
        else
            System.out.println(0);
    }

    public static void init() {
        parent = new int[N];
        rank = new int[N];
        for (int i = 0; i < N; i++)
            parent[i] = i;
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;
        if (rank[x] < rank[y])
            parent[x] = y;
        else {
            parent[y] = x;
            if (rank[x] == rank[y])
                rank[x]++;
        }

    }

    public static int find(int target) {
        if (target == parent[target])
            return target;
        else
            return parent[target] = find(parent[target]);
    }
}

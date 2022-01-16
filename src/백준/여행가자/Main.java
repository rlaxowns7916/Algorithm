package 백준.여행가자;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] parent;
    public static int[] route;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        init();
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                if (Integer.parseInt(st.nextToken()) == 1)
                    union(i, j);
            }
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++)
            route[i] = Integer.parseInt(st.nextToken());
        solve();
    }

    public static void solve() {
        int start = find(route[0]);
        for (int i = 1; i < M; i++) {
            if (find(route[i]) != start) {
                System.out.println("NO");
            }
        }
        System.out.println("YES");
    }

    public static void init() {
        parent = new int[N + 1];
        route = new int[M];
        for (int i = 1; i <= N; i++)
            parent[i] = i;
    }

    public static void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if (parentX == parentY)
            return;
        if (parentX < parentY)
            parent[parentY] =parentX;
        else
            parent[parentX] = parentY;
    }

    public static int find(int target) {
        if (target == parent[target])
            return target;
        else
            return parent[target] = find(parent[target]);
    }
}

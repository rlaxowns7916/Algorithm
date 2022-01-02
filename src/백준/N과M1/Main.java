package 백준.N과M1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static boolean[] visited;
    public static int[] temp;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N];
        temp = new int[N];

        solve(0, 0);
        System.out.println(sb.toString());
    }

    public static void solve(int depth, int count) {
        if (count == M) {
            for (int i = 0; i < count; i++) {
                sb.append(temp[i]).append(" ");
            }
            sb.append("\n");
        } else if (depth < N) {
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                temp[count] = i + 1;
                solve(depth + 1, count + 1);
                visited[i] = false;
            }
        }
    }
}

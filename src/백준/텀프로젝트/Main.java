package 백준.텀프로젝트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int count = 0;
    public static boolean[] visit;
    public static boolean[] done;

    public static void main(String[] args) throws IOException {
        int t = 0, n = 0;
        int i = 0, j = 0;
        int[] students;

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        t = Integer.parseInt(br.readLine());

        for (i = 0; i < t; i++) {
            count = 0;
            n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visit = new boolean[n + 1];
            done = new boolean[n + 1];
            st = new StringTokenizer(br.readLine());
            for (j = 1; j <= n; j++)
                students[j] = Integer.parseInt(st.nextToken());
            for (j = 1; j <= n; j++) {
                if (!done[j])
                    dfs(j, students);
            }
            sb.append(n - count).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int target, int[] students) {
        if (visit[target]) {
            count++;
            done[target] = true;
        } else
            visit[target] = true;
        int next = students[target];
        if (!done[next])
            dfs(next, students);
        done[target] = true;
    }
}

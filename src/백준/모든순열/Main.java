package 백준.모든순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static int N = 0, count = 0, factorial = 0;
    public static int[] store;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        store = new int[N];
        visit = new boolean[N];
        for (int i = 0; i < N; i++)
            store[i] = i + 1;

        perm(0);
        System.out.println(sb);
    }

    public static void perm(int count) {
        if (count == N) {
            for (int i = 0; i < N; i++)
                sb.append(store[i]).append(" ");
            sb.append("\n");
        }
        for (int i = 0; i < N; i++) {
            if (!visit[i]) {
                visit[i] = true;
                store[count] = i + 1;
                perm(count+ 1);
                visit[i] = false;
            }
        }
    }
}
package 백준.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static int N = 0, cnt = 0;
    public static int[] col;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        col = new int[N];

        solve(0);
        System.out.println(cnt);
    }

    public static void solve(int depth) {
        if (depth == N) {
            cnt++;
        }
        for (int i = 0; i < N; i++) {
            if (isPromising(depth, i)) {
                col[depth] = i;
                solve(depth + 1);
            }
        }
    }

    public static boolean isPromising(int depth, int now) {
        for (int i = 0; i < depth; i++) {
            if (col[i] == now || (depth - i == Math.abs(now - col[i])))
                return false;
        }
        return true;
    }
}

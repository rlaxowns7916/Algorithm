package 백준.신나는함수실행;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int[][][] memoization = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        int a = 0, b = 0, c = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1)
                break;
            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") ").append("= ").append(recursion(a, b, c)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int recursion(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0)
            return 1;
        else if (a > 20 || b > 20 || c > 20)
            return recursion(20, 20, 20);
        else if (memoization[a][b][c] != 0)
            return memoization[a][b][c];
        else if (a < b && b < c)
            return memoization[a][b][c] = recursion(a, b, c - 1) + recursion(a, b - 1, c - 1) - recursion(a, b - 1, c);
        else
            return memoization[a][b][c] = recursion(a - 1, b, c) + recursion(a - 1, b - 1, c) + recursion(a - 1, b, c - 1) - recursion(a - 1, b - 1, c - 1);

    }
}

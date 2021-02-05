package 백준.집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int M = 0;
    public static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        M = Integer.parseInt(br.readLine());
        int bitmask = 0, value = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            String statement = st.nextToken();
            if (st.hasMoreTokens())
                value = Integer.parseInt(st.nextToken());
            bitmask = solve(bitmask, statement, value);
        }
        System.out.println(sb.toString());
    }

    public static int solve(int bitmask, String token, int num) {
        if (token.equals("add")) {
            return bitmask | 1 << num;
        } else if (token.equals("remove")) {
            return bitmask & ~(1 << num);
        } else if (token.equals("check")) {
            if((bitmask & 1 << num) > 0)
               sb.append(1).append("\n");
            else
                sb.append(0).append("\n");
            return bitmask;
        } else if (token.equals("toggle")) {
            return bitmask ^ 1 << num;
        } else if (token.equals("all")) {
            for (int i = 1; i <= 20; i++)
                bitmask = bitmask | 1 << i;
            return bitmask;
        } else
            return 0;
    }
}
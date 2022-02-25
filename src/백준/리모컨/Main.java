package 백준.리모컨;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, min;
    public static boolean[] isBroke = new boolean[10];

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        min = Math.abs(N - 100);
        if (M > 0) {
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++) {
                isBroke[Integer.parseInt(st.nextToken())] = true;
            }
        }

        for (int i = 0; i <= 999999; i++) {
            boolean isPromising = true;
            String searchNum = String.valueOf(i);

            for (int j = 0; j < searchNum.length(); j++) {
                if (isBroke[searchNum.charAt(j) - '0']) {
                    isPromising = false;
                    break;
                }
            }
            if (isPromising) {
                int diff = Math.abs(N - i) + searchNum.length();
                min = Math.min(min, diff);
            }
        }
        System.out.println(min);
    }
}

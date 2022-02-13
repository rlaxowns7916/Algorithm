package programmers.level3.멀리뛰기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] map = new int[2001];

        map[1] = 1;
        map[2] = 2;

        for (int i = 3; i <= N; i++) {
            map[i] = (map[i - 1] + map[i - 2]) % 1234567;
        }
        System.out.println(map[N]);

    }
}

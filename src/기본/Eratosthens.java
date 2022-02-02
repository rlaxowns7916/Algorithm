package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Eratosthens {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        boolean[] primeNum = new boolean[n + 1];

        Arrays.fill(primeNum, true);
        primeNum[0] = primeNum[1] = false;

        for (int i = 2; i <= n / 2; i++) {
            if (!primeNum[i])
                continue;
            for (int j = 2* i; j <= n; j += i) {
                primeNum[j] = false;
            }
        }
        for (int i = 2; i <= n; i++) {
            if (primeNum[i])
                sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}

package 백준.소수의연속합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int left = 0, right = 0, count = 0;
        long sum = 0;
        ArrayList<Integer> primes = new ArrayList<>();
        boolean[] nonPrime = new boolean[N + 1];

        nonPrime[0] = nonPrime[1] = true;
        for (int i = 2; i <= N / 2; i++) {
            if (nonPrime[i])
                continue;
            for (int j = 2 * i; j <= N; j += i)
                nonPrime[j] = true;
        }

        for (int i = 1; i <= N; i++) {
            if (nonPrime[i])
                continue;
            primes.add(i);
        }
        while (true) {
            if (left == primes.size())
                break;
            if (sum >= N) {
                if (sum == N)
                    count++;
                sum -= primes.get(left++);
            } else {
                if (right == primes.size())
                    break;
                else
                    sum += primes.get(right++);
            }
        }
        System.out.println(count);
    }
}

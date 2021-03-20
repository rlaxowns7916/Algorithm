package 백준.이모티콘;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] dp = new int[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int S = Integer.parseInt(br.readLine());
        System.out.println(getNum(S));
    }

    public static int getNum(int num) {
        if (num > 1) {
            if (dp[num] != 0)
                return dp[num];
            else if (num % 2 == 0) {
                int temp = num;
                for (int i = 2; i <= num / 2; i++) {
                    if (num % i == 0)
                        temp = Math.min(temp, getNum(i) + num / i);
                }
                return dp[num] = temp;
            } else {
                return dp[num] = Math.min(getNum(num + 1) + 1, num);
            }
        } else
            return 0;
    }
}

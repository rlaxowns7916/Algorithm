package 백준.크게만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        int N = 0, K = 0;
        int num1 = 0, num2 = 0, deleteCount = 0;

        boolean[] isUsed;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        String input = br.readLine();
        isUsed = new boolean[N];

        for (i = 0; i < N && deleteCount < K; i++) {
            num1 = input.charAt(i) - '0';
            for (j = i - 1; j >= 0; j--) {
                num2 = input.charAt(j) - '0';
                if (num1 <= num2 || deleteCount >= K)
                    break;
                if (!isUsed[j]) {
                    deleteCount++;
                    isUsed[j] = true;
                }
            }
        }
        for (i = N - 1; i >= 0 && deleteCount < K; i--) {
            if (isUsed[i])
                continue;
            deleteCount++;
            isUsed[i] = true;
        }

        for (i = 0; i < N; i++) {
            if (isUsed[i])
                continue;
            sb.append(input.charAt(i));
        }
        System.out.println(sb);
    }
}
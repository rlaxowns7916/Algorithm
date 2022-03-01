package 백준.수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, K = 0;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        int sum = 0, max = 0, lp = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < K; i++)
            sum += numbers[i];
        max = sum;
        for (int i = K; i < N; i++) {
            sum -= numbers[lp++];
            sum += numbers[i];
            max = Math.max(max, sum);
        }
        System.out.println(max);
    }
}

package 백준.두용액;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        int lp = 0, rp = 0, left = 0, right = 0, min = Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        numbers = new int[N];
        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(numbers);

        lp = 0;
        rp = N - 1;

        while (lp < rp) {
            int temp = numbers[lp] + numbers[rp];
            int abs = Math.abs(temp);
            if (min > abs) {
                left = numbers[lp];
                right = numbers[rp];

                min = abs;
            }
            if (temp > 0)
                rp--;
            else
                lp++;
        }
        sb.append(left).append(" ").append(right);
        System.out.println(sb);
    }
}

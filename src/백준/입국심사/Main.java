package 백준.입국심사;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] managers;

    public static void main(String[] args) throws IOException {
        long left = 0, right = 0, mid = 0, answer = Long.MAX_VALUE;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        managers = new int[N];
        for (int i = 0; i < N; i++)
            managers[i] = Integer.parseInt(br.readLine());

        Arrays.sort(managers);
        left = 1;
        right = (long) M * managers[N - 1];

        while (left <= right) {
            long counter = 0;
            mid = (left + right) / 2;

            for (int manager : managers)
                counter += mid / manager;

            if (counter < M) {
                left = mid + 1;
            } else {
                right = mid - 1;
                answer = Math.min(answer, mid);
            }
        }
        System.out.println(answer);
    }
}

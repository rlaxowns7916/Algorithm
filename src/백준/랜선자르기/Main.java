package 백준.랜선자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int K = 0, N = 0;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        long max = -1;
        long[] lan;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        lan = new long[K];

        for (i = 0; i < K; i++) {
            lan[i] = Long.parseLong(br.readLine());
            max = Math.max(max, lan[i]);
        }
        System.out.println(func(lan, max));
    }

    public static long func(long[] lan, long max) {
        long count = 0, num = 0, temp = 0, start = 1, end = max, mid = 0;
        while (start <= end) {
            count = 0;
            mid = (start + end) / 2;
            for (int i = 0; i < K; i++)
                count += lan[i] / mid;
            if (count >= N)
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }
}

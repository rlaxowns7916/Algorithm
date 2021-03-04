package 백준.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LoopVersion {
    public static long diff = Long.MAX_VALUE, similar = 0;

    public static void main(String[] args) throws IOException {
        int i = 0, N = 0;
        long M = 0, max = Long.MIN_VALUE, ans = 0;
        long[] trees;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Long.parseLong(st.nextToken());

        trees = new long[N];
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++) {
            trees[i] = Long.parseLong(st.nextToken());
            max = Math.max(trees[i], max);
        }
        System.out.println(find(trees, 0, max, M));
    }

    public static long find(long[] trees, long min, long max, long height) {
        long mid = 0, start = min, end = max;
        while (start <= end) {
            mid = (start + end) / 2;
            if (check(trees, mid, height))
                start = mid + 1;
            else
                end = mid - 1;
        }
        return end;
    }

    public static boolean check(long[] trees, long cut, long height) {
        long ans = 0;
        for (long tree : trees)
            ans += Math.max(tree - cut, 0);
        return ans >= height;
    }
}
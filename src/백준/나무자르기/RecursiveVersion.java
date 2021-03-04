package 백준.나무자르기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RecursiveVersion {
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
        ans = find(trees, 0, max, M);
        if (ans == 0)
            System.out.println(similar);
        else
            System.out.println(ans);
    }

    public static long find(long[] trees, long start, long end, long height) {
        if (start > end)
            return 0;
        else {
            long mid = (start + end) / 2, length = getLength(trees, mid);
            if (length == height)
                return mid;
            else if (length < height)
                return find(trees, start, mid - 1, height);
            else {
                if (length - height < diff) {
                    diff = length - height;
                    similar = mid;
                }
                return find(trees, mid + 1, end, height);
            }
        }
    }

    public static long getLength(long[] trees, long height) {
        long ans = 0;
        for (long tree : trees)
            ans += Math.max(tree - height, 0);
        return ans;
    }
}

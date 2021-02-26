package 백준.저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] nums = new int[N + 1], acc = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (i = 1; i <= N; i++)
            nums[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(nums);

        for (i = 1; i <= N; i++)
            acc[i] = nums[i] + acc[i - 1];


        System.out.println(func(nums, acc));
    }

    public static int func(int[] nums, int[] acc) {
        int i = 0, len = acc.length;
        for (i = 1; i < len; i++) {
            if (acc[i - 1] + 1 < nums[i])
                return acc[i - 1] + 1;
        }
        return acc[i - 1] + 1;
    }
}

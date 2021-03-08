package 백준.공유기설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, C = 0;

    public static void main(String[] args) throws IOException {
        int i = 0, mid = 0, left = 0, right = 0;
        int[] arr;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (i = 0; i < N; i++)
            arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);
        left = 1;
        right = arr[N - 1] - arr[0];

        while (left <= right) {
            mid = (left + right) / 2;
            if (isPossible(arr, mid))
                left = mid + 1;
            else
                right = mid - 1;
        }
        System.out.println(right);
    }

    public static boolean isPossible(int[] arr, int diff) {
        int i = 0, cnt = 1, prev = 0;
        prev = arr[0];
        for (i = 1; i < N; i++) {
            if (arr[i] - prev >= diff) {
                cnt++;
                prev = arr[i];
            }
        }
        if (cnt >= C)
            return true;
        else
            return false;
    }
}

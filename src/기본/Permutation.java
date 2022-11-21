package 기본;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Permutation {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //perm(0, n, arr);

        for (int i = 1; i <= n; i++) {
            sizePerm(0, n, 0, i, arr);
        }
    }

    public static void perm(int now, int max, int[] arr) {
        if (now == max) {
            StringBuilder sb = new StringBuilder();
            for (int num : arr) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
            System.out.println(sb);
        } else {
            for (int i = now; i < max; i++) {
                swap(now, i, arr);
                perm(now + 1, max, arr);
                swap(now, i, arr);
            }
        }
    }

    public static void sizePerm(int now, int max, int nowSize, int maxSize, int[] arr) {
        if (nowSize == maxSize) {
            StringBuilder sb = new StringBuilder();
            for(int i=1;i<=nowSize;i++){
                sb.append(arr[i-1]).append(" ");
            }
            sb.append("\n");
            System.out.println(sb);
        } else {
            for (int i = now; i < max; i++) {
                swap(now, i, arr);
                sizePerm(now + 1, max, nowSize + 1, maxSize, arr);
                swap(now, i, arr);
            }
        }
    }

    public static void swap(int x, int y, int[] arr) {
        int tmp = arr[x];
        arr[x] = arr[y];
        arr[y] = tmp;
    }
}

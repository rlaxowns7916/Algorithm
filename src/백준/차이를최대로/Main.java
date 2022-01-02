package 백준.차이를최대로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, MAX = 0;
    public static int[] arr, temp;
    public static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new int[N];
        temp = new int[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        calculate(0);
        System.out.println(MAX);
    }
    public static void calculate(int count) {
        if (count == N) {
            int sum = 0;
            for (int i = 0; i < N - 1; i++) {
                sum += Math.abs(temp[i] - temp[i + 1]);
            }
            MAX = Math.max(MAX, sum);
        } else {
            for (int i = 0; i < N; i++) {
                if (visited[i])
                    continue;
                visited[i] = true;
                temp[count] = arr[i];
                calculate(count + 1);
                visited[i] = false;
            }
        }
    }
}
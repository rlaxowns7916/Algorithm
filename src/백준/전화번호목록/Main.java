package 백준.전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0, N = Integer.parseInt(br.readLine()), M = 0;
        boolean flag = true;
        String[] arr;

        for (i = 0; i < N; i++) {
            flag = true;
            M = Integer.parseInt(br.readLine());
            arr = new String[M];
            for (j = 0; j < M; j++) {
                arr[j] = br.readLine();
            }
            Arrays.sort(arr);
            for (j = 0; j < M - 1; j++) {
                if (arr[j + 1].startsWith(arr[j])) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}

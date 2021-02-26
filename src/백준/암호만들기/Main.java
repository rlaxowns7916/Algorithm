package 백준.암호만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static char[] arr;
    public static int L = 0, C = 0, motherCount = 0, childCount = 0;
    public static String mother = "aeiou";
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        boolean check = false;
        boolean[] visit;

        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = br.readLine().replace(" ", "").toCharArray();
        visit = new boolean[C];
        Arrays.sort(arr);

        func(visit, 0, 0);
        System.out.println(sb.toString());
    }

    public static void func(boolean[] visit, int depth, int now) {
        if (depth == L && motherCount >= 1 && childCount >= 2) {
            int i = 0, count = 0;
            for (i = 0; i < C; i++) {
                if (count == L)
                    break;
                else if (visit[i]) {
                    sb.append(arr[i]);
                    count++;
                }
            }
            sb.append("\n");
        } else if (now < C) {
            visit[now] = true;
            if (mother.contains(String.valueOf(arr[now]))) {
                motherCount++;
                func(visit, depth + 1, now + 1);
                motherCount--;
            } else {
                childCount++;
                func(visit, depth + 1, now + 1);
                childCount--;
            }
            visit[now] = false;
            func(visit, depth, now + 1);
        }
    }
}

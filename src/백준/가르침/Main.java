package 백준.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0, K = 0, ans = 0;
    public static String[] str;
    public static boolean[] visit = new boolean[26];

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        visit['a' - 'a'] = visit['t' - 'a'] = visit['c' - 'a'] = visit['n' - 'a'] = visit['i' - 'a'] = true;

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (K >= 5) {
            str = new String[N];
            for (i = 0; i < N; i++)
                str[i] = br.readLine();
            check(1, 0);
        }
        System.out.println(ans);
    }

    public static void check(int now, int count) {
        if (count == K - 5) {
            int val = 0;
            for (String token : str) {
                boolean flag = true;
                for (int i = 4; i < token.length() - 4; i++) {
                    if (!visit[token.charAt(i) - 'a']) {
                        flag = false;
                        break;
                    }
                }
                if (flag)
                    val++;
            }
            ans = Math.max(ans, val);
        }
        else if(K -5 -count <= 26-now) {
            for (int i = now; i < 26; i++) {
                if(visit[i])
                    continue;
                visit[i] = true;
                check(i + 1, count + 1);
                visit[i] = false;
            }
        }
    }
}
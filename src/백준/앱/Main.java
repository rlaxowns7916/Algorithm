package 백준.앱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static int MAXCOST = 10001;
    public static int N = 0, M = 0;
    public static int MIN = 20000001;
    public static App[] apps;
    public static long[][] dp;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st1 = new StringTokenizer(br.readLine()), st2;

        N = Integer.parseInt(st1.nextToken());
        M = Integer.parseInt(st1.nextToken());

        apps = new App[N];
        dp = new long[N][MAXCOST];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (i = 0; i < N; i++)
            apps[i] = new App(Integer.parseInt(st1.nextToken()), Integer.parseInt(st2.nextToken()));

        Arrays.sort(apps);
        for (i = 0; i < N; i++) {
            for (j = 0; j < MAXCOST; j++) {
                if (i == 0) {
                    dp[i][j] = j < apps[i].cost ? 0 : apps[i].memory;
                } else {
                    if (j < apps[i].cost)
                        dp[i][j] = dp[i - 1][j];
                    else
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - apps[i].cost] + apps[i].memory);
                }
                if (dp[i][j] >= M)
                    MIN = Math.min(MIN, j);
            }
        }
        System.out.println(MIN);
    }

    static class App implements Comparable<App> {
        int memory;
        int cost;

        public App(int memory, int cost) {
            this.memory = memory;
            this.cost = cost;
        }

        @Override
        public int compareTo(App o) {
            return this.cost - o.cost;
        }
    }
}

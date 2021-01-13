package programmers.level2.땅따먹기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] Map = new int[N][4];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<N;i++) {
            for(int j=0;j<4;j++)
                Map[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(Map));
    }
    public static int solution(int[][] Map) {
        int[][] dp = new int[Map.length][4];
        int i = 0, j = 0,ans=0;
        for (i = 0; i < Map.length; i++) {
            for (j = 0; j < 4; j++) {
                if (i == 0)
                    dp[i][j] = Map[i][j];
                else
                    dp[i][j] = Map[i][j]+getMax(dp[i-1], j);
            }
        }
        for(i=0;i<4;i++)
            ans = Math.max(ans,dp[Map.length-1][i]);
        return ans;
    }
    public static int getMax(int[]Row, int index)
    {
        int max=0,i=0;
        for(i=0;i<4;i++){
            if(i == index)
                continue;
            max = Math.max(max,Row[i]);
        }
        return max;
    }
}

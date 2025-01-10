package programmers.level2.숫자변환하기;

public class Solution {
    public int solution(int x, int y, int n) {
        int[] dp = new int[3000001];
        if(x == y){
            return 0;
        }else{
            dp[x * 2] = dp[x * 3] = dp[x+n] = 1;
            for(int i=x;i<=y;i++){
                if(dp[i] > 0 || i == x){
                    dp[i * 2] = dp[i * 2] == 0 ? dp[i] + 1 :  Math.min(dp[i * 2], dp[i]+1);
                    dp[i * 3] = dp[i * 3] == 0 ? dp[i] + 1 : Math.min(dp[i * 3], dp[i]+1);
                    dp[i + n] = dp[i + n] == 0 ? dp[i] + 1 : Math.min(dp[i + n], dp[i]+1);
                }
            }

            return dp[y] == 0 ? -1 : dp[y];
        }
    }
}

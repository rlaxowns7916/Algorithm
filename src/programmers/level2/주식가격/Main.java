package programmers.level2.주식가격;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n  = Integer.parseInt(br.readLine());
        int[] prices = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0;i<n;i++)
            prices[i] = Integer.parseInt(st.nextToken());

        for(int ans : solution(prices))
            System.out.println(ans);
    }
    public static int[] solution(int[] prices)
    {
        int i=0,j=0;
        int[] ans = new int[prices.length];
        for(i=0;i<prices.length;i++){
            int count =0;
            for(j=i+1;j<prices.length;j++){
                if(prices[i] > prices[j])
                    break;
            }
            if(j == prices.length)
                ans[i] = j-i-1;
            else
                ans[i] = j - i;
        }
        return ans;
    }
}

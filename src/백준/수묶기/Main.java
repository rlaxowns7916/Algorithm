package 백준.수묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static int N = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=0;
        N = Integer.parseInt(br.readLine());
        int[] nums = new int[N];

        for(i=0;i<N;i++)
            nums[i] = Integer.parseInt(br.readLine());
        Arrays.sort(nums);
        System.out.println(solve(nums));
    }
    public static int solve(int[] nums){
        int i=0,sum=0,index=0;
        boolean isBreak = false;
        for(i = N-1;i>=0;i--){
           if(nums[i] > 0){
               if(i-1>=0 && nums[i-1] >1){
                   sum += nums[i]*nums[i-1];
                   i--;
               }else
                   sum += nums[i];
           }else
               break;
        };
        for(i=0;i<N;i++){
            if(nums[i] < 0){
                if(i+1<N){
                    if(nums[i+1] >= 0){
                        if(nums[i+1] > 0)
                            sum += nums[i];
                        break;
                    }
                    else{
                        sum += nums[i]*nums[i+1];
                        i++;
                    }
                }else
                    sum += nums[i];
            }else
                break;
        }
        return sum;
    }
}

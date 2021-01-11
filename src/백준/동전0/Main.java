package 백준.동전0;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()), k = Integer.parseInt(st.nextToken());
        int[] val = new int[n];
        for(int i=0;i<n;i++){
            val[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(val,k));
    }
    public static int solution(int[] val, int k)
    {
        int i = 0,sum=0,count=0;

        for(i=val.length-1;i>=0 && k != 0;i--){
            if(k<val[i])
                continue;
            count = count + k/val[i];
            k = k%val[i];
        }
        return count;
    }
}

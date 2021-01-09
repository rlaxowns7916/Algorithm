package 백준.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(calculate(str));
        br.close();
    }
    public static int calculate(String str) {
        StringTokenizer minusTokenizer = new StringTokenizer(str, "-");
        StringTokenizer plusTokenizer;
        boolean first = true;
        int ans = 0, plusOrMinus = str.charAt(0) == '-'?-1:1;

        while(minusTokenizer.hasMoreTokens()){
            int tmp =0;
            String minusToken = minusTokenizer.nextToken();
            plusTokenizer = new StringTokenizer(minusToken,"+");

            while(plusTokenizer.hasMoreTokens()){
                String plusToken = plusTokenizer.nextToken();
                if(plusOrMinus == -1){
                    ans = plusOrMinus * Integer.parseInt(plusToken);
                    plusOrMinus = 0;
                }else
                    tmp += Integer.parseInt(plusToken);
            }
            if(first){
                ans += tmp;
                first = false;
            }else
                ans -= tmp;
        }
        return ans;
    }
}
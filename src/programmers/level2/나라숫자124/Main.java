package programmers.level2.나라숫자124;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());

        System.out.println(solution(n));
    }
    public static String solution(int n)
    {
        String[] val = {"4","1","2"};
        String ret ="";

        while(n>0)
        {
            int mod = n % 3;
            n = n/3;
            if(mod == 0)
                n--;
            ret = val[mod]+ret;
        }
        return ret;
    }
}

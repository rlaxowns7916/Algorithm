package programmers.leveltest1.promblem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int x = Integer.parseInt(br.readLine());

        System.out.println(check(x));
    }
    public static boolean check(int x){
        int sum=0;
        String numStr = String.valueOf(x);

        for(int i=0;i<numStr.length();i++){
            sum += Integer.parseInt(String.valueOf(numStr.charAt(i)));
        }

        return x % sum == 0;
    }
}

package 백준.좋은수열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N = 0;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        backtracking("1", 1);
    }

    public static void backtracking(String str, int length) {

        if (flag)
            return;

        if(check(str)){
            if(length == N){
                System.out.println(str);
                flag = true;
            }else{
                for (int i = 1; i <= 3; i++) {
                    str += i;
                    backtracking(str, str.length());
                    str = str.substring(0, str.length() - 1);
                }
            }
        }
    }

    public static boolean check(String str) {
        int i = 0, j = 0, length = str.length();

        for (i = 1; i <= length / 2; i++) {
            if (str.substring(length - 2 * i, length - i).equals(str.substring(length - i)))
                return false;
        }
        return true;
    }
}

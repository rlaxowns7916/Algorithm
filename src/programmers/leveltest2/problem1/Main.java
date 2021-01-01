package programmers.leveltest2.problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
    public static String solution(String str){
        String ret="";
        str = str.toLowerCase();
        for(int i=0;i<str.length();i++){
           char tmp = str.charAt(i);
           if((tmp <= 'z' && tmp>='a') && (i ==0 || str.charAt(i-1) ==' '))
               tmp = (char)(tmp-32);

           ret+=tmp;
       }
        return ret;
    }
}

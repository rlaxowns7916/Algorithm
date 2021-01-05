package programmers.level2.문자열압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(solution(str));
    }
    public static int solution(String str){
        int length = str.length(),ret=0,min = length;
        for(int i=1;i<=length/2;i++){
            ret = calculate(str,i);
            min = min>=ret?ret:min;
        }
        return min;
    }
    public static int calculate(String str, int subLength)
    {
        int length = str.length(),count=1;
        String subString=str.substring(0,subLength),ans="";
        for(int i=subLength;i<length;i+=subLength){
            if(i+subLength <= length){
                String nextSubString = str.substring(i,i+subLength);
                if(subString.equals(nextSubString))
                    count++;
                else{
                    ans = stringify(ans,subString,count);
                    count=1;
                    subString = nextSubString;
                }
            }else{
                ans = stringify(ans,subString,count);
                subString = str.substring(i);
                count = 1;
            }
        }
        ans = stringify(ans,subString,count);
        return ans.length();
    }
    public static String stringify(String ans, String str, int count){
        if(count == 1)
            ans += str;
        else
            ans += count+str;
        return ans;
    }
}

package programmers.level2.큰수만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());

        System.out.println(solution(str,k));
    }
    public static String solution(String number,int k)
    {
        int length = number.length(),needToCheck = length - k,max = -1,index=-1,i=0,j=0;
        boolean flag=false;
        String ans="";

        while(true)
        {
            max=0;
            if(needToCheck == 0)
                break;
            if(!flag) {
                j = 0;
                flag = true;
            }else
                j = index+1;

            if(length - j <= needToCheck){
                ans += number.substring(j);
                break;
            }else{
              for( ;j<=length-needToCheck;j++){
                  if(max < number.charAt(j)-'0'){
                      max = number.charAt(j)-'0';
                      index=j;
                  }
              }
                ans+=max;
                needToCheck--;
            }
        }
        return ans;
    }
}

package programmers.level2.괄호변환;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
    /*
        W를 U와 V로 나누는데, U는 균형잡힌 문자열(개수가 같음) + 더이상 나눌 수 없음. V는 빈문자열 가능
        U가 올바른문자열 이라면, V에게 똑같은 과정 반복. 수행이 끝나면 V를 U에 붙인다.

        문자열 U가 올바른 문자열이 아니라면,
        ( 문자열에 V에다가 위 단계를 실행하여 붙인다 그리고 뒤에 )를 붙인다
        U의 첫번쨰 문자와 마지막 문자를 제거,
     */
    public static String solution(String p){
        String str = p,u,v;
        String[] splits;

        if(isCorrect(p) || p.length() == 0)
            return p;

        else{
            splits = splitString(str);

            u = splits[0];
            v = splits[1];

            if(isCorrect(u)){
               return u+solution(v);
            }else{
                return "("+solution(v)+")"+changeDirection(u.substring(1,u.length()-1));
            }
        }
    }
    public static String changeDirection(String str){
        String ans ="";
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);

            if(tmp == '(')
                ans += ')';
            else
                ans += '(';
        }
        return ans;
    }
    public static boolean isCorrect(String str)
    {
        Stack<Character> st = new Stack();
        boolean flag= true;
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(tmp == '(')
                st.push(tmp);

            else{
                if(st.size() == 0){
                    flag = false;
                    break;
                }
                st.pop();
            }
        }
        if(flag && st.size() == 0)
            return true;
        return false;
    }
    public static String[] splitString(String str){
        int left=0,right=0,i=0;
        String[] splits = new String[2];

        for(i=0;i<str.length();i++){
            char tmp = str.charAt(i);

            if(tmp == '(')
                right++;
            else left ++;

            if(left == right)
                break;
        }
        splits[0] =  str.substring(0,i+1);
        splits[1] = str.substring(i+1);

        return splits;
    }
}

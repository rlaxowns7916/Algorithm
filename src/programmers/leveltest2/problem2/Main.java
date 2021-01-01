package programmers.leveltest2.problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
    static boolean solution(String str){
        Stack stack = new Stack();
        boolean flag = true;

        for(int i=0;i<str.length();i++){
            char temp = str.charAt(i);
            if(temp == '(')
                stack.push(temp);
            else if(temp ==')'){
                if(stack.size() == 0){
                    flag = false;
                    break;
                }else
                    stack.pop();
            }
        }
        return flag == true && stack.size() ==0;
    }
}

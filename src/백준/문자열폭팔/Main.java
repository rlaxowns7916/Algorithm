package 백준.문자열폭팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        System.out.println(solve(str,bomb));
    }
    public static String solve(String str, String bomb){
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int i=0,j=0,count=0;
        char chr;
        for(i=0;i<str.length();i++){
            stack.push(str.charAt(i));

            if(stack.size() >= bomb.length()){
                boolean flag = true;
                for(j=0;j<bomb.length();j++){
                    if(stack.get(stack.size()-bomb.length()+j) != bomb.charAt(j)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    for(j=0;j<bomb.length();j++)
                        stack.pop();
                }
            }
        }
       for(i=0;i<stack.size();i++)
           sb.append(stack.get(i));
        return sb.length()==0?"FRULA":sb.toString();
    }
}

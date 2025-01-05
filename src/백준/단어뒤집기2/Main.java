package 백준.단어뒤집기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        boolean isTag = false;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        StringBuilder answer = new StringBuilder();
        StringBuilder subString = new StringBuilder();

        for(int i=0;i< input.length();i++){
            char current = input.charAt(i);
            if(current == '<'){
                isTag = true;
                answer.append(subString.reverse());
                subString = new StringBuilder();
                subString.append(current);
            }else if(current == ' '){
                if(isTag){
                    subString.append(current);
                }else{
                    answer.append(subString.reverse());
                    answer.append(current);
                    subString = new StringBuilder();
                }
            }else if(current == '>'){
                isTag = false;
                subString.append(current);
                answer.append(subString);
                subString = new StringBuilder();
            }else{
                subString.append(current);
            }
        }
        if(subString.length() != 0){
            answer.append(subString.reverse());
        }

        System.out.println(answer);
    }
}

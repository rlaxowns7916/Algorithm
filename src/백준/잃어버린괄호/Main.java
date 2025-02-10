package 백준.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] operandWithMinus = br.readLine().split("-");

        for(int i=0; i< operandWithMinus.length;i++){
            String[] operand = operandWithMinus[i].split("\\+");
            int current = Integer.parseInt(operand[0]);
            for(int j=1; j < operand.length;j++){
                current += Integer.parseInt(operand[j]);
            }

            answer = i == 0 ? current : answer - current;
        }
        System.out.println(answer);
    }
}

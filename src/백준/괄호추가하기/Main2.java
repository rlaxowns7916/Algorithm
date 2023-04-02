package 백준.괄호추가하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
  public static long max = Long.MIN_VALUE;
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine());
    char[] operators = new char[n/2];
    int[] numbers = new int[n/2 +1];

    String expression = br.readLine();


    for(int i=0;i<n;i++){
      if(i % 2 == 0){
        numbers[i/2] = expression.charAt(i) - '0';
      }else{
        operators[i/2] = expression.charAt(i);
      }
    }
    solve(numbers[0],n/2,0,numbers,operators);
    System.out.println(max);
  }

  public static void solve(long value,int n, int depth,int[] numbers, char[] operators){

    if(n <= depth){
      max = Long.max(max,value);
    }else {
      solve(calculate(value,numbers[depth+1],operators[depth]),n,depth+1,numbers,operators);
      if(depth+1 < n)
        solve(
            calculate(
                value, calculate(numbers[depth+1],numbers[depth+2],operators[depth+1]), operators[depth]
            ),n,depth+2,numbers,operators);
      }
  }
  public static long calculate(long operand1, long operand2, char op){
    if(op == '+'){
      return operand1 + operand2;
    }else if(op == '*'){
      return operand1 * operand2;
    }else if(op == '-')
      return operand1 - operand2;
    return 0;
  }
}

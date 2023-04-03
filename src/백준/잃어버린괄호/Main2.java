package 백준.잃어버린괄호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main2 {

  public static void main(String[] args) throws IOException {
    int result=0;
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String input = br.readLine();
    StringTokenizer st1 = new StringTokenizer(input,"-");

    int divideExpressionSize = st1.countTokens();

    for(int i=0;i<divideExpressionSize;i++){
      StringTokenizer st2 = new StringTokenizer(st1.nextToken(),"+");
      int numberSize = st2.countTokens();
      for(int j=0;j< numberSize;j++){
        if(i == 0){
          result += Integer.parseInt(st2.nextToken());
        }else{
          result -= Integer.parseInt(st2.nextToken());
        }
      }
    }
  System.out.println(result);
  }
}

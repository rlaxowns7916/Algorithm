package 백준.수들의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    long input = Long.parseLong(br.readLine());
    long start = 1, end = input;


    while(start <= end){
      long mid = (start+end) / 2;

      if(mid * (mid+1) <= 2 * input){
        start = mid+1;
      }else{
        end = mid-1;
      }
    }
    System.out.println(end);
  }
}


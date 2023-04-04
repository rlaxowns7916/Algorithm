package 백준.단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main2 {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Map<Character, Integer> numberMap = new HashMap<>();
    int n = Integer.parseInt(br.readLine());

    for (int i = 0; i < n; i++) {
      String input = br.readLine();
      int len = input.length();
      for(int j=len-1;j>=0;j--){
        char chr = input.charAt(j);
        int value = (int)Math.pow(10,len-1-j);

        if(numberMap.containsKey(chr)){
          numberMap.put(chr,numberMap.get(chr) + value);
        }else{
          numberMap.put(chr,value);
        }
      }
    }

    System.out.println(solve(numberMap));
  }
  public static int solve(Map<Character,Integer> numberMap){
    int result = 0;
    int allocator = 9;
    List<Integer> sum = new ArrayList<>(numberMap.values());
    sum.sort(((o1, o2) -> o2-o1));

    for(int num : sum){
      result += allocator-- * num;
    }
    return result;
  }
}
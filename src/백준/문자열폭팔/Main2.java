package 백준.문자열폭팔;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main2 {

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    ArrayList<Character> store = new ArrayList<>();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    String input = br.readLine();
    String bomb = br.readLine();

    for (int i = 0; i < input.length(); i++) {
      boolean isExplode = true;
      store.add(input.charAt(i));

      if (store.size() >= bomb.length()) {
        for (int j = bomb.length() - 1; j >= 0; j--) {
          if(store.get(store.size()-1-(bomb.length()-1-j)) != bomb.charAt(j)){
            isExplode = false;
            break;
          }
        }

        if(isExplode){
          for(int j=0;j<bomb.length();j++) {
            store.remove(store.size()-1);
          }
        }
      }
    }

    if(store.isEmpty()) {
      sb.append("FRULA");
    }
    else {
      store.forEach(sb::append);
    }
    System.out.println(sb);
  }
}

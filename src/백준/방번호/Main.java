package 백준.방번호;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] counter = new int[10];
    String roomNumber = br.readLine();
    int normal = 0, special = 0, result = 0;

    for (int i = 0; i < roomNumber.length(); i++) {
      int value = roomNumber.charAt(i) - '0';

      counter[value] += 1;

      if (value != 6 && value != 9) {
        normal = Math.max(normal, counter[value]);
      }
    }
    special = counter[6] + counter[9];
    result = normal >= special ? normal : special % 2 == 0 ? special / 2 : special / 2 + 1;

    System.out.println(result);

  }

}

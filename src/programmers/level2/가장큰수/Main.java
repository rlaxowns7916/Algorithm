package programmers.level2.가장큰수;

import java.util.Arrays;
import java.util.Objects;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int[] input = {3, 30, 34, 5, 9};

    System.out.println(main.solution(input));
  }

  public String solution(int[] numbers) {
    StringBuilder sb = new StringBuilder();
    String[] strings = transform(numbers);
    Arrays.sort(strings, (o1, o2) -> {
      String str1 = o1 + o2;
      String str2 = o2 + o1;

      return str2.compareTo(str1);
    });
    if (Objects.equals(strings[0], "0")) {
      sb.append(strings[0]);
    } else {
      for (String string : strings) {
        sb.append(string);
      }
    }
    return sb.toString();
  }

  public String[] transform(int[] numbers) {
    int len = numbers.length;
    String[] strings = new String[len];

    for (int i = 0; i < len; i++) {
      strings[i] = String.valueOf(numbers[i]);
    }
    return strings;
  }

}

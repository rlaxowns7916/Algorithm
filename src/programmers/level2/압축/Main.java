package programmers.level2.압축;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    main.solution("TOBEORNOTTOBEORTOBEORNOT");

  }

  public Integer[] solution(String msg) {
    int counter = 1;
    int index = 0;
    ArrayList<Integer> result = new ArrayList<>();
    Map<String, Integer> dictionary = new LinkedHashMap<>();

    for (counter = 1; counter <= 26; counter++) {
      char ch = 'A' - 1;
      String key = String.valueOf((char) (ch + counter));
      dictionary.put(key, counter);
    }

    while (index < msg.length()) {
      for (int i = index; i < msg.length(); ) {
        String subString = msg.substring(index, i + 1);
        if (dictionary.containsKey(subString)) {
          i++;
          if (i == msg.length()) {
            result.add(dictionary.get(subString));
            index = i;
          }
        } else {
          int output = dictionary.get(subString.substring(0, subString.length() - 1));
          dictionary.put(subString, counter++);
          result.add(output);
          index = i;
          break;
        }
      }
    }
    return result.toArray(new Integer[0]);
  }

}

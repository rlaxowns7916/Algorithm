package programmers.level2.영어끝말잇기;

import java.util.LinkedHashSet;
import java.util.Set;

public class Main {

  public static void main(String[] args) {

  }

  public int[] solution(int n, String[] words) {
    int user = 0, turn = 0;
    boolean isBreak = false;
    char preKeywordLastCharacter = ' ';
    Set<String> duplicateChecker = new LinkedHashSet<>();

    for (int i = 0; i < words.length && !isBreak; i++) {
      String keyword = words[turn];
      user %= n;
      turn = (i / n) + 1;
      if (i == 0) {
        duplicateChecker.add(keyword);
      } else if (!validate(preKeywordLastCharacter, keyword) || !duplicateChecker.add(keyword)) {
        isBreak = true;
      }

      user++;
      preKeywordLastCharacter = keyword.charAt(keyword.length() - 1);
    }

    if (!isBreak) {
      return new int[]{user, turn};
    } else {
      return new int[]{0, 0};
    }
  }

  public boolean validate(char preKeywordLastCharacter, String keyword) {
    return preKeywordLastCharacter == ' ' || (preKeywordLastCharacter == keyword.charAt(
        keyword.length() - 1));
  }

}

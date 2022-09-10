package programmers.level2.캐시;

import java.util.LinkedList;

public class Main {

  public static void main(String[] args) {

  }

  public int solution(int cacheSize, String[] cities) {
    int cnt = 0;
    LinkedList<String> cache = new LinkedList<>();
    if (cacheSize == 0) {
      cnt = 5 * cities.length;
    } else {
      for (String city : cities) {
        String target = city.toUpperCase();

        if (cache.isEmpty()) {
          cache.addLast(target);
          cnt += 5;
        } else if (cache.remove(target)) {
          cnt += 1;
          cache.addLast(target);
        } else {
          if (cache.size() == cacheSize) {
            cache.removeFirst();
          }
          cache.addLast(target);
          cnt += 5;
        }
      }
    }
    return cnt;
  }

}

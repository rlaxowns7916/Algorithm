package programmers.level3;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Main {

  /**
   * 야근 피로도 = 남은 야근일 * 작업량 1시간 동안 1의 작업 처리 가능
   * <p>
   * n: 퇴근까지 남은 시간 works: 남은 작업량
   */
  public long min = Integer.MAX_VALUE;

  public long solution(int n, int[] works) {
    long ans = 0;
    PriorityQueue<Work> pq = new PriorityQueue<>();

    for (int i = 0; i < works.length; i++) {
      pq.add(new Work(i, works[i]));
    }
    while (n > 0) {
      if (!pq.isEmpty() && pq.peek().remain > 0) {
        Work extraWork = pq.poll();
        Work afterExtraWork = new Work(extraWork.day, extraWork.remain - 1);
        pq.add(afterExtraWork);
      }
      n--;
    }
    for (Work work : pq) {
      ans += (long)(Math.pow(work.remain,2));
    }
    return ans;
  }

  class Work implements Comparable<Work> {

    int day;
    int remain;

    public Work(int day, int remain) {
      this.day = day;
      this.remain = remain;
    }

    @Override
    public int compareTo(Work o) {
      return o.remain - this.remain;
    }
  }
}

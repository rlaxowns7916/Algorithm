package programmers.level3.디스크컨트롤러;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {
    static class Disk implements Comparable<Disk> {
        int start = 0;
        int playTime = 0;

        public Disk(int start, int playTime) {
            this.start = start;
            this.playTime = playTime;
        }

        @Override
        public int compareTo(Disk o) {
            if (this.playTime == o.playTime)
                return this.start - o.start;
            return this.playTime - o.playTime;
        }
    }

    public static void main(String[] args) {
        int[][] jobs = {{0, 3}, {1, 9}, {2, 6}};
        System.out.println(solve(jobs));
    }

    public static int solve(int[][] jobs) {
        int i = 0, count = 0, now = 0, row = 0, col = 0, sum = 0;
        PriorityQueue<Disk> pq = new PriorityQueue<>();
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (count < jobs.length) {
            /**
             * 현재시점에서 실행 가능한 작업 모두 큐에 넣기
             */
            while (i < jobs.length && now >= jobs[i][0]) {
                pq.add(new Disk(jobs[i][0], jobs[i][1]));
                i++;
            }
            if (pq.isEmpty())
                now = jobs[i][0];
            else {
                Disk current = pq.poll();
                sum += now - current.start + current.playTime;
                now = now + current.playTime;
                count++;
            }
        }
        return sum / jobs.length;
    }
}

package programmers.level2.과제진행하기;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;

class Main {

  public String[] solution(String[][] plans) {
    int currentTime = 0;
    Stack<Schedule> previousJob = new Stack<>();
    PriorityQueue<Schedule> nextJob = new PriorityQueue<>();
    List<String> finish = new LinkedList<>();

    for (String[] plan : plans) {
      String subject = plan[0];
      String start = plan[1];
      int range = Integer.parseInt(plan[2]);

      nextJob.add(new Schedule(subject, start, range));
    }

    currentTime = nextJob.peek().start;
    while (!nextJob.isEmpty()) {
      Schedule now = nextJob.poll();
      if (currentTime < now.start) {
        int diff = now.start - currentTime;
        while (!previousJob.isEmpty()) {
          Schedule previous = previousJob.pop();
          if (diff >= previous.range) {
            diff -= previous.range;
            currentTime += previous.range;
            finish.add(previous.subject);
          } else {
            previous.doWork(diff);
            previousJob.add(previous);
            break;
          }
        }
      }
      currentTime = now.start;
      if (nextJob.isEmpty()) {
        finish.add(now.subject);
      } else {
        int diff = nextJob.peek().start - now.start;
        if (now.range <= diff) {
          finish.add(now.subject);
          currentTime += now.range;
        } else {
          now.doWork(diff);
          previousJob.push(now);
          currentTime += diff;
        }
      }
    }

    while (!previousJob.isEmpty()) {
      finish.add(previousJob.pop().subject);
    }
    return finish.toArray(new String[0]);
  }
}

class Schedule implements Comparable<Schedule> {

  public String subject;
  public int start;
  public int range;

  public Schedule(String subject, String start, int range) {
    this.subject = subject;
    this.start = parseTimeToNumber(start);
    this.range = range;
  }

  public void doWork(int time) {
    this.range -= time;
  }

  private int parseTimeToNumber(String start) {
    StringTokenizer st = new StringTokenizer(start, ":");
    return parseTimeToNumber(st.nextToken(), st.nextToken());
  }

  private int parseTimeToNumber(String hour, String minute) {
    return Integer.parseInt(hour) * 60 + Integer.parseInt(minute);
  }

  @Override
  public int compareTo(Schedule o) {
    return this.start - o.start;
  }
}


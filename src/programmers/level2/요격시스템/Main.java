package programmers.level2.요격시스템;

import java.util.*;
class Solution {
  public int solution(int[][] targets) {
    List<Point> points = new ArrayList<>();
    int answer = 0;
    double lastPoint = -1;

    for(int[] target : targets){
      points.add(new Point(target[0],target[1]));
    }
    Collections.sort(points);

    for(Point point: points){
      if(point.x > lastPoint){
        lastPoint = point.y - 0.5;
        answer++;
      }
    }
    return answer;
  }
}
class Point implements Comparable<Point>{
  int x=0;
  int y=0;

  public Point(int x, int y){
    this.x = x;
    this.y = y;
  }

  @Override
  public int compareTo(Point o){
    return this.y - o.y;
  }
}
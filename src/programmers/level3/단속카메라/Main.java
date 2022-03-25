package programmers.level3.단속카메라;

import java.util.ArrayList;
import java.util.Collections;

class Main {
    class Solution {
        class Route implements Comparable<Route> {
            int start = 0;
            int end = 0;

            public Route(int start, int end) {
                this.start = start;
                this.end = end;
            }

            @Override
            public int compareTo(Route o) {
                return this.end - o.end;
            }
        }

        public int solution(int[][] routes) {
            int count = 0;
            ArrayList<Route> lists = new ArrayList<>();
            int lastCamera = Integer.MIN_VALUE;

            for (int[] route : routes) {
                lists.add(new Route(route[0], route[1]));
            }
            Collections.sort(lists);

            for (Route route : lists) {
                if (route.start <= lastCamera)
                    continue;
                lastCamera = route.end;
                count++;
            }
            return count;
        }
    }
}
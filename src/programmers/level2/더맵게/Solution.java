package programmers.level2.더맵게;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        Arrays.stream(scoville).forEach(pq::add);

        while(pq.size() >= 2 && pq.peek() < K ){
            int first = pq.poll();
            int second = pq.poll();
            int newOne = first + second * 2;

            count++;
            pq.add(newOne);
        }

        if(pq.peek() == null || pq.peek() < K){
            return -1;
        }else{
            return count;
        }
    }
}
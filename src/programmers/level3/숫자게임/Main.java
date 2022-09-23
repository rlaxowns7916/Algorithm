package programmers.level3.숫자게임;

import java.util.*;

public class Main {
    public int solution(int[] A, int[] B) {
        int ans = 0;
        Map<Integer, Integer> counter = new LinkedHashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        Arrays.sort(A);
        for (int num : B) {
            maxHeap.add(num);
            minHeap.add(num);

            if (!counter.containsKey(num)) {
                counter.put(num, 0);
            }
            counter.put(num, counter.get(num) + 1);
        }

        for (int i = A.length - 1; i >= 0; i--) {
            while (true) {
                if(maxHeap.isEmpty() || minHeap.isEmpty()){
                    break;
                }
                if (maxHeap.peek() > A[i]) {
                    int num = maxHeap.poll();
                    if (counter.get(num) > 0) {
                        counter.put(num, counter.get(num) - 1);
                        ans++;
                        break;
                    }
                } else if (maxHeap.peek() == A[i]) {
                    int num = minHeap.poll();
                    if (counter.get(num) > 0) {
                        counter.put(num, counter.get(num) - 1);
                        break;
                    }
                } else {
                    int num = minHeap.poll();
                    if (counter.get(num) > 0) {
                        counter.put(num, counter.get(num) - 1);
                        break;
                    }
                }
            }
        }
        return ans;
    }
}

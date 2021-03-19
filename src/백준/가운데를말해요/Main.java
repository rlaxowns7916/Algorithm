package 백준.가운데를말해요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine()), i = 0, num = 0;

        for (i = 0; i < n; i++) {
            num = Integer.parseInt(br.readLine());
            if (maxHeap.size() == minHeap.size())
                maxHeap.add(num);
            else
                minHeap.add(num);
            if (!maxHeap.isEmpty() && !minHeap.isEmpty()) {
                if (maxHeap.peek() > minHeap.peek()) {
                    int temp = maxHeap.poll();
                    maxHeap.add(minHeap.poll());
                    minHeap.add(temp);
                }
            }
            sb.append(maxHeap.peek()).append("\n");
        }
        System.out.println(sb.toString());
    }
}

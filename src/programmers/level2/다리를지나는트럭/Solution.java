package programmers.level2.다리를지나는트럭;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int currentTime = 0;
        int bridgeWeight = 0;
        Queue<int[]> bridge = new LinkedList<>();
        int truckIndex = 0;

        while (truckIndex < truck_weights.length || !bridge.isEmpty()) {
            currentTime++;

            if (!bridge.isEmpty() && currentTime - bridge.peek()[1] >= bridge_length) {
                bridgeWeight -= bridge.poll()[0];
            }

            if (truckIndex < truck_weights.length
                    && bridgeWeight + truck_weights[truckIndex] <= weight
                    && bridge.size() < bridge_length) {
                bridge.add(new int[] { truck_weights[truckIndex], currentTime });
                bridgeWeight += truck_weights[truckIndex];
                truckIndex++;
            }
        }

        return currentTime;
    }
}

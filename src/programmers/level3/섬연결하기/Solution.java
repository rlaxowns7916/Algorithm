package programmers.level3.섬연결하기;

import java.util.PriorityQueue;

public class Solution {

    public int solution(int n, int[][] costs) {
        int answer = 0, visitCount = 0;
        boolean[] visit = new boolean[n];
        int[][] map = new int[n][n];
        PriorityQueue<Node> pq = new PriorityQueue<>();

        for(int[] cost: costs){
            int n1 = cost[0];
            int n2 = cost[1];
            int metric = cost[2];

            map[n1][n2] = map[n2][n1] = metric;
        }

        visit[0] = true;
        visitCount++;

        for(int i=0;i<n;i++){
            if(map[0][i] != 0){
                pq.add(new Node(i,map[0][i]));
            }
        }

        while(!pq.isEmpty() && visitCount != n){
            Node current = pq.poll();

            if(!visit[current.to]){
                visitCount++;
                visit[current.to] = true;

                for(int i=0;i<n;i++){
                    if(map[current.to][i] != 0 && !visit[i]){
                        pq.add(new Node(i,map[current.to][i]));
                    }
                }


                answer += current.metric;
            }
        }

        return answer;
    }

    static class Node implements Comparable<Node>{
        int to;
        int metric;

        public Node(int to, int metric){
            this.to = to;
            this.metric = metric;
        }

        @Override
        public int compareTo(Node o) {
            return metric - o.metric;
        }
    }
}
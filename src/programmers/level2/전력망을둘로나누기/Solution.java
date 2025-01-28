package programmers.level2.전력망을둘로나누기;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;
        int[][] map = new int[n][n];


        for(int[] wire: wires){
            int from = wire[0] - 1;
            int to = wire[1] - 1;
            map[from][to] = map[to][from] = 1;
        }


        for(int[] wire: wires){
            int from = wire[0] - 1;
            int to = wire[1] - 1;

            map[from][to] = map[to][from] = 0;
            answer = Math.min(answer,traverse(map));
            map[from][to] = map[to][from] = 1;
        }


        return answer;
    }

    private int traverse(int[][] map){
        ArrayList<Integer> answers = new ArrayList<>();
        Queue<Integer> nodes = new LinkedList<>();
        boolean[] visit = new boolean[map.length];

        for(int i=0;i< map.length ; i++){
            if(!visit[i]){
                int area = 1;
                nodes.add(i);
                visit[i] = true;

                while(!nodes.isEmpty()){
                    int current = nodes.poll();
                    for(int j=0; j< map.length ; j++){
                        if(map[current][j] == 1 && !visit[j]){
                            nodes.add(j);
                            visit[j] = true;
                            area++;
                        }
                    }
                }
                answers.add(area);
            }
        }
        return Math.abs(answers.get(0) - answers.get(1));
    }
}

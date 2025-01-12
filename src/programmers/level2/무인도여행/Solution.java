package programmers.level2.무인도여행;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    private final int[] dx = {-1,0,1,0};
    private final int[] dy = {0,1,0,-1};

    public Integer[] solution(String[] maps) {
        int w = maps.length;
        int h = maps[0].length();
        ArrayList<Integer> answer = new ArrayList<>();

        int[][] map = new int[w][h];
        boolean[][] visit = new boolean[w][h];

        for(int i=0; i<w;i++){
            for(int j=0;j<h;j++){
                char value = maps[i].charAt(j);
                map[i][j] = value == 'X' ? - 1: value - '0';
            }
        }

        for(int i=0;i<w;i++){
            for(int j=0; j<h ;j++){
                if(map[i][j] != -1 && !visit[i][j]){
                    int search = search(i,j,map,visit);

                    if(search > 0){
                        answer.add(search);
                    }
                }
            }
        }

        if(answer.isEmpty()){
            answer.add(-1);
        }

        return answer.stream().sorted().toArray(Integer[]::new);
    }

    private int search(int x, int y, int[][]map, boolean[][] visit){
        int sum = map[x][y];
        Queue<Integer> qx = new LinkedList<>();
        Queue<Integer> qy = new LinkedList<>();

        qx.add(x);
        qy.add(y);
        visit[x][y] = true;

        while(!qx.isEmpty() && !qy.isEmpty()){
            int nowX = qx.poll();
            int nowY = qy.poll();

            for(int i=0;i<4;i++){
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if(nextX >=0 && nextX < map.length && nextY>=0 && nextY < map[0].length && map[nextX][nextY] != -1 && !visit[nextX][nextY]){
                    sum += map[nextX][nextY];
                    visit[nextX][nextY] = true;

                    qx.add(nextX);
                    qy.add(nextY);
                }
            }
        }

        return sum;
    }
}

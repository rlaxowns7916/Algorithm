package programmers.level1.공원산책;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public int[] solution(String[] park, String[] routes) {
        int nowX = 0;
        int nowY = 0;
        int nextX = 0;
        int nextY = 0;
        Map<String, Integer> directionIndexes= new LinkedHashMap<>();
        int[][] map = new int[park.length][];
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};

        directionIndexes.put("N",0);
        directionIndexes.put("E",1);
        directionIndexes.put("S",2);
        directionIndexes.put("W",3);

        for(int i =0; i< park.length; i++){
            String row = park[i];
            if(i == 0){map = new int[park.length][row.length()];}

            for(int j=0; j < row.length();j++){
                if(row.charAt(j) == 'S'){
                    nowX = i;
                    nowY = j;
                }else if(row.charAt(j) == 'X') {
                    map[i][j] = -1;
                }
            }
        }

        for(String route : routes){
            boolean isProcessed = true;

            int px = nowX;
            int py = nowY;

            String[] tokens = route.split(" ");

            String direction = tokens[0];
            int step = Integer.parseInt(tokens[1]);
            int directionIndex = directionIndexes.get(direction);

            for(int i=0;i < step ; i++){
                nextX = nowX + dx[directionIndex];
                nextY = nowY + dy[directionIndex];

                if(nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length || map[nextX][nextY] == -1){
                    isProcessed = false;
                }
                nowX = nextX;
                nowY = nextY;
            }

            if(!isProcessed){
                nowX = px;
                nowY = py;
            }
        }

        return new int[] {nowX,nowY};
    }
}

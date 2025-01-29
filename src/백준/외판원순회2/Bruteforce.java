package 백준.외판원순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Bruteforce {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int min = Integer.MAX_VALUE;
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int [N][N];
        boolean[] visit = new boolean[N];

        for(int i=0; i<N;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<N;j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<N;i++){
            min = Math.min(min, traverse(i,i,0,0, map,visit));
        }

        System.out.println(min);
    }

    private static int traverse(int startNode, int current, int metric, int traveled, int[][] map, boolean[] visit){
        if(traveled == visit.length){
            if(startNode == current){
                return metric;
            }else{
                return Integer.MAX_VALUE;
            }
        }else{
            int minTravelMetric = Integer.MAX_VALUE;
            for(int i=0;i<map.length;i++){
                int nextMetric = map[current][i];
                if(nextMetric > 0 && !visit[i]){
                    visit[i] = true;
                    minTravelMetric = Math.min(minTravelMetric, traverse(startNode,i, metric + nextMetric,traveled + 1, map,visit));
                    visit[i] = false;
                }
            }

            return minTravelMetric;
        }
    }
}

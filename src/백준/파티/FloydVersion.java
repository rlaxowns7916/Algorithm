package 백준.파티;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class FloydVersion {
    static int N=0,M=0,X=0,max=0,INF=9999999;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0,j=0,start=0,end=0,time=0;
        int[][] Map;
        //학생의 수
        N = Integer.parseInt(st.nextToken());
        //도로의 수
        M = Integer.parseInt(st.nextToken());
        //파티 할 장소
        X = Integer.parseInt(st.nextToken());
        Map = new int[N+1][N+1];

        for(i=1;i<=N;i++){
            for(j=1;j<=N;j++){
                if(i == j)
                    continue;
                Map[i][j] =INF;
            }
        }

        for(i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            time = Integer.parseInt(st.nextToken());
            Map[start][end]=time;
        }
        solve(Map);
        System.out.println(max);
    }
    public static void solve(int[][] Map)
    {
        int i=0,j=0,k=0;

        for(k=1;k<=N;k++)
        {
             for(i=1;i<=N;i++)
             {
                 for(j=1;j<=N;j++)
                 {
                     if(Map[i][k] + Map[k][j] < Map[i][j])
                         Map[i][j] = Map[i][k]+Map[k][j];
                 }
             }
        }

        for(i=1;i<=N;i++)
            max = Math.max(max,Map[i][X]+Map[X][i]);
    }
}
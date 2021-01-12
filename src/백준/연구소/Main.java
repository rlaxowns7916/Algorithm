package 백준.연구소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Point> virus = new java.util.ArrayList();
    static int max = -1, N = 0, M = 0, wall_count = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = 0, j = 0, num = 0;
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < M; j++) {
                num = Integer.parseInt(st.nextToken());
                if (num == 2)
                    virus.add(new Point(i, j));
                else if (num == 1)
                    wall_count++;
                map[i][j] = num;
            }
        }
        solution(map, 0, 0, 0);
        System.out.println(max);
    }

    public static void solution(int[][] Map, int wall, int x, int y) {
        int i = x, j = y;

        if (wall == 3)
            BFS(Map);
        else {
            for ( ; i < N; i++) {
                for (; j < M; j++) {
                    if(Map[i][j] == 0)
                    {
                        Map[i][j] = 1;
                        solution(Map, wall + 1, i, j+1);
                        Map[i][j] = 0;
                    }
                }
                j=0;
            }
        }
    }
    public static void BFS(int[][] Map)
    {
        int nx=0,ny=0,x=0,y=0,i=0,count=0,ans=0;
        int[][] copyMap = mapCopy(Map);
        Queue<Point> queue = new LinkedList<>();
        queue.addAll(virus);

        while(!queue.isEmpty())
        {
            Point point = queue.poll();
            x = point.x;
            y = point.y;
            count++;

            for(i=0;i<4;i++){
                nx = x+dx[i];
                ny = y+dy[i];

                if(nx>=0 && ny>=0 && nx<N && ny < M && copyMap[nx][ny] == 0){
                    queue.add(new Point(nx,ny));
                    copyMap[nx][ny] = 2;
                }
            }
        }
        ans = N*M - (count+wall_count+3);
        max = Math.max(max,ans);
    }
    public static int[][] mapCopy(int[][] Map)
    {
        int[][] copyMap = new int[N][M];

        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                copyMap[i][j] = Map[i][j];
        }
        return copyMap;
    }
}
class Point
{
    int x;
    int y;

    public Point(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
}

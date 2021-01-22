package 백준.녹색옷입은애가젤다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static int[] dx={-1,0,1,0},dy={0,1,0,-1};
    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int Brupee;

        public Node(int x,int y, int Brupee){
            this.x = x;
            this.y = y;
            this.Brupee = Brupee;
        }
        @Override
        public int compareTo(Node o) {
            return this.Brupee - o.Brupee;
        }
    }
    public static void main(String[] args) throws IOException {
        int n=0,count=1,ans=0;
        while(true){
            n = Integer.parseInt(br.readLine());
            if(n == 0)
                break;
            else{
                ans = solve(n);
                System.out.format("Problem %d: %d\n",count++,ans);
            }
        }
    }
    public static int solve(int n) throws IOException {
        int i=0,j=0,x=0,y=0,nx=0,ny=0,Brupee=0,ans=Integer.MAX_VALUE;
        int[][] map = input(n);
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visit = new boolean[n][n];

        pq.add(new Node(0,0,map[0][0]));
        while(!pq.isEmpty()) {
            Node now = pq.poll();

            x = now.x;
            y = now.y;
            Brupee = now.Brupee;

            if(x == n-1 && y == n-1)
                ans = Brupee<ans?Brupee:ans;
            else if(visit[x][y])
                continue;
            else{
                visit[x][y]=true;
                for(i=0;i<4;i++){
                    nx = x+dx[i];
                    ny = y+dy[i];

                    if(nx>=0 && ny>=0 && nx<n && ny<n && !visit[nx][ny])
                        pq.add(new Node(nx,ny,Brupee+map[nx][ny]));
                }
            }
        }
        return ans;
    }
    public static int[][] input(int n) throws IOException {
        int[][] map = new int[n][n];
        int i=0,j=0;

        for(i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(j=0;j<n;j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }
        return map;
    }
}
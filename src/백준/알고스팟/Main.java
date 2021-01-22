package 백준.알고스팟;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N=0, M=0;
    public static int[][] Map;
    public static int[] dx = {-1,0,1,0}, dy={0,1,0,-1};

    public static class Node implements Comparable<Node>{
        int x;
        int y;
        int wall;

        public Node(int x,int y,int wall){
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
        @Override
        public int compareTo(Node o) {
            return this.wall - o.wall;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0,j=0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Map = new int[M][N];

        for(i=0;i<M;i++){
            String str = br.readLine();
            for(j=0;j<N;j++)
                Map[i][j] = str.charAt(j)-'0';
        }

        System.out.println(BFS());
    }
    public static int BFS() {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        boolean[][] visit = new boolean[M][N];
        int x=0,y=0,wall=0,nx=0,ny=0,i=0,ans=N*M;

        queue.add(new Node(0,0,0));
        while(!queue.isEmpty()) {
            Node now = queue.poll();
            x = now.x;
            y = now.y;
            wall = now.wall;

            if(x == M-1 && y == N-1)
                ans = wall<ans?wall:ans;
            else if(visit[x][y])
                continue;
            else{
                visit[x][y] = true;
                for(i=0;i<4;i++){
                    nx = x+dx[i];
                    ny = y+dy[i];

                    if(nx>=0 && nx<M && ny >=0 && ny <N){
                        if(!visit[nx][ny] || (nx == M-1 && ny == N-1)){
                            if(Map[nx][ny] == 1)
                                queue.add(new Node(nx,ny,wall+1));
                            else
                                queue.add(new Node(nx,ny,wall));
                        }
                    }
                }
            }
        }
        return ans;
    }
}
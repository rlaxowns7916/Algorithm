package 백준.나무제태크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static class Tree implements Comparable<Tree>{
        int x;
        int y;
        int age;

        public Tree(int x,int y,int age){
            this.x = x;
            this.y = y;
            this.age = age;
        }

        @Override
        public int compareTo(Tree o) {
            return this.age - o.age;
        }
    }
    public static int N=0,M=0,K=0;
    public static int[][] plus,Map;
    public static int[] dx={-1,-1,-1,0,0,1,1,1},dy={-1,0,1,-1,1,-1,0,1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Tree> surviveTrees = new PriorityQueue<>();
        int i=0,j=0,r=0,c=0,age=0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        plus = new int[N+1][N+1];
        Map = new int[N+1][N+1];
        for(i=1;i<=N;i++){
            st = new StringTokenizer(br.readLine());
            for(j=1;j<=N;j++){
                plus[i][j] = Integer.parseInt(st.nextToken());
                Map[i][j] = 5;
            }
        }
        for(i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            age = Integer.parseInt(st.nextToken());

            surviveTrees.add(new Tree(r,c,age));
        }
        System.out.println(survive(surviveTrees));
    }
    public static int survive(PriorityQueue<Tree> pq)
    {
        int i=0,x=0,y=0,age=0,year=0,next_x=0,next_y=0;
        PriorityQueue<Tree> tempStore = new PriorityQueue<>();
        Queue<Tree> dieTress = new LinkedList<>();
        for(year=0;year<K;year++){
            while(!pq.isEmpty()){
                Tree now = pq.poll();

                x = now.x;
                y = now.y;
                age = now.age;

                if(Map[x][y] >= age){
                    Map[x][y] -= age;
                    tempStore.add(new Tree(x,y,age+1));
                }else{
                    dieTress.add(now);
                    continue;
                }
                if(age % 5 == 0){
                    for(i=0;i<8;i++){
                        next_x = x+dx[i];
                        next_y = y+dy[i];
                        if(next_x>0 && next_y>0 && next_x<=N && next_y<=N)
                            tempStore.add(new Tree(next_x,next_y,1));
                    }
                }
            }
            addNutrition();
            addDieTressNutrition(dieTress);
            pq.addAll(tempStore);
            tempStore.clear();
        }
        return pq.size();
    }
    public static void addDieTressNutrition(Queue<Tree> dieTress){
        while(!dieTress.isEmpty()){
            Tree now = dieTress.poll();
            Map[now.x][now.y] += now.age/2;
        }
    }
    public static void addNutrition(){
        for(int i=1;i<=N;i++){
            for(int j=1;j<=N;j++)
                Map[i][j] += plus[i][j];
        }
    }
}

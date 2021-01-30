package 백준.감시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int min = Integer.MAX_VALUE,N=0,M=0;
    public static int[] dx = {-1,0,1,0},dy={0,1,0,-1};
    public static Route[] routes = new Route[6];
    public static class Coordinate{
        int x;
        int y;
        int type;

        Coordinate(int x,int y,int type){
            this.x = x;
            this.y = y;
            this.type = type;
        }
    }
    public static class Route{
        ArrayList<ArrayList<Integer>> store= new ArrayList();
    }
    public static void main(String[] args) throws IOException {
        int i=0,j=0;
        int[][] Map;
        Queue<Coordinate> cctv = new LinkedList();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new int[N][M];

        for(i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            for(j=0;j<M;j++){
                Map[i][j] =  Integer.parseInt(st.nextToken());
                if(Map[i][j] != 0 && Map[i][j] != 6)
                    cctv.add(new Coordinate(i,j,Map[i][j]));
            }
        }
        init();
        solve(cctv,Map);
        System.out.println(min);
    }
    public static void solve(Queue<Coordinate> cctv,int[][] Map)
    {
        if(cctv.size() == 0)
            min = Math.min(min,calculate(Map));
        else{
            int type=0,x=0,y=0,nx=0,ny=0;
            ArrayList<ArrayList<Integer>> route;
            Queue<Coordinate> copyCctv = new LinkedList();
            copyCctv.addAll(cctv);

            while(!copyCctv.isEmpty()){
                Coordinate temp = copyCctv.poll();
                type = temp.type;
                route = routes[type].store;
                for(ArrayList<Integer> spread : route){
                    int[][] copyMap = copy(Map);
                    for(Integer direction : spread){
                        x = temp.x;
                        y=  temp.y;
                        while(true){
                            nx = x+dx[direction];
                            ny = y+dy[direction];

                            if(nx >=0 && ny >=0 && nx < N && ny <M){
                                if(Map[nx][ny] == 6)
                                    break;
                                else if(Map[nx][ny] == 0)
                                    copyMap[nx][ny] = type;
                                x=nx;
                                y=ny;
                            }else
                                break;
                        }
                    }
                    solve(copyCctv,copyMap);
                }
            }
        }
    }
    public static int[][] copy(int[][] Map){
        int[][] copyMap = new int[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++)
                copyMap[i][j] = Map[i][j];
        }
        return copyMap;
    }
    public static int calculate(int[][] Map){
        int i=0,j=0,count=0;
        for(i=0;i<N;i++){
            for(j=0;j<M;j++){
                if(Map[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
    public static void init(){
        int i=0,j=0;

        for(i=1;i<=5;i++)
            routes[i] = new Route();

        for(i=0;i<4;i++){
            routes[1].store.add(new ArrayList());
            routes[1].store.get(i).add(i);
        }
        for(i=0;i<2;i++){
            routes[2].store.add(new ArrayList());
            routes[2].store.get(i).add(i);
            routes[2].store.get(i).add(i+2);
        }
        for(i=0;i<4;i++){
            routes[3].store.add(new ArrayList());
            routes[3].store.get(i).add(i);
            routes[3].store.get(i).add((i+1)%4);
        }
        for(i=0;i<4;i++){
            routes[4].store.add(new ArrayList());
            for(j=0;j<4;j++){
                if(i == j)
                    continue;
                routes[4].store.get(i).add(j);
            }
        }
        routes[5].store.add(new ArrayList());
        for(i=0;i<4;i++)
            routes[5].store.get(0).add(i);
    }
}
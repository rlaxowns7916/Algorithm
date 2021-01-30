package 백준.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static class Info implements Comparable<Info>{
        int index;
        int weight;

        public Info(int index,int weight){
            this.index = index;
            this.weight = weight;
        }

        @Override
        public int compareTo(Info o) {
            return this.weight - o.weight;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i=0,j=0;
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Integer> edge = new ArrayList<>();
        PriorityQueue<Info> pq = new PriorityQueue();


        st = new StringTokenizer(br.readLine());
        for(i=0;i<N-1;i++)
            edge.add(Integer.parseInt(st.nextToken()));

        st = new StringTokenizer(br.readLine());
        for(i=0;i<N-1;i++)
            pq.add(new Info(i,Integer.parseInt(st.nextToken())));

        System.out.println(solve(edge,pq));
}
    public static  long solve(ArrayList<Integer> edge,PriorityQueue<Info> pq){
        long count = 0,length=0,ans=0;
        int i=0,j=0,index=0,weight=0;
        boolean[] visit = new boolean[N-1];

        while(!pq.isEmpty() && count != N-1){
            Info temp = pq.poll();
            weight = temp.weight;
            index  = temp.index;
            length  = 0;
            for(j=index;j<N-1;j++){
                if(visit[j])
                    break;
                length += edge.get(j);
                visit[j] = true;
                count++;
            }
            ans += weight*length;
        }
        return ans;
    }
}
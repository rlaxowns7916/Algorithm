package 백준.네트워크복구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N=0,M=0;
    public static class Node implements Comparable<Node>{
        int target;
        int time;

        public Node(int target,int time){
            this.target = target;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<List<Node>> network= new ArrayList<>();
        int i=0,a=0,b=0,c=0;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(i=0;i<=N;i++)
            network.add(new ArrayList<>());

        for(i=0;i<M;i++)
        {
            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            network.get(a).add(new Node(b,c));
            network.get(b).add(new Node(a,c));
        }
        System.out.println(solve(network));
    }

    /**
     * MST가 안되는 이유 --> 최소간선의 노드합 != 슈퍼컴퓨터 최단거리를 통한 ST간선 합
     */
    public static String solve(List<List<Node>> network)
    {
        int i=0,count=0,time=0,target=0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        List<Node> ans = new ArrayList<>();
        boolean[] visit = new boolean[N+1];
        int[] times = new int[N+1],parents = new int[N+1];

        Arrays.fill(times,Integer.MAX_VALUE);
        times[1]=0;
        pq.add(new Node(1,0));
        while(!pq.isEmpty())
        {
            Node now = pq.poll();

            target = now.target;
            time = now.time;

            if(times[target] < time || visit[target])
                continue;

            visit[target]=true;
            for(Node connection : network.get(target)){
                if(times[connection.target] > times[target]+connection.time){
                    times[connection.target] = times[target]+connection.time;
                    pq.add(new Node(connection.target,times[connection.target]));
                    parents[connection.target] = target;
                }
            }
        }
        sb.append(N-1).append("\n");

        for(i=2;i<=N;i++)
            sb.append(parents[i]).append(" ").append(i).append("\n");
        return sb.toString();
    }
}
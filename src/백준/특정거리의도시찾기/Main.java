package 백준.특정거리의도시찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<List<Node>> map = new ArrayList<>();
    public static int N=0,M=0,K=0,X=0;

    public static class Node implements Comparable<Node>{

        int target=0;
        int weight=0;

        public Node(int target,int weight)
        {
            this.target = target;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i=0,start=0,end=0;

        /**
        *  모든 도로의 거리는 1이다.
        */
        N = Integer.parseInt(st.nextToken()); //도시의 개수
        M = Integer.parseInt(st.nextToken()); // 도로의 개수
        K = Integer.parseInt(st.nextToken()); // 거리 정보
        X = Integer.parseInt(st.nextToken()); // 출발 도시의 번호

        for(i=0;i<=N;i++)
            map.add(new ArrayList<>());

        for(i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            map.get(start).add(new Node(end,1));
        }
        print(dijkstra(X));

    }
    public static int[] dijkstra(int start)
    {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int[] ans = new int[N+1];
        boolean[] visit = new boolean[N+1];
        Arrays.fill(ans,99999);
        ans[start] = 0;

        pq.add(new Node(start,0));

        while(!pq.isEmpty()) {
            int index = pq.poll().target;
            if(visit[index])
                continue;

            visit[index] = true;
            for(Node node : map.get(index)){
                if(ans[node.target] > ans[index]+node.weight){
                    ans[node.target] = ans[index]+node.weight;
                    pq.add(new Node(node.target,ans[node.target]));
                }
            }
        }
        return ans;
    }
    public static void print(int[] ans) {
        boolean flag = false;
        for(int i=1;i<=N;i++){
            if(ans[i] == K){
                System.out.println(i);
                flag=true;
            }
        }
        if(!flag)
            System.out.println(-1);
    }
}
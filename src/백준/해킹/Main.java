package 백준.해킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0;
    public static  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static StringTokenizer st;

    public static class Info implements Comparable<Info>{
        int slave;
        int time;

        public Info(int slave,int time){
            this.slave = slave;
            this.time = time;
        }

        @Override
        public int compareTo(Info o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        int i=0,n=0,d=0,c=0;
        int[] ans = new int[2];
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());


        for(i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); //computer 개수
            d = Integer.parseInt(st.nextToken()); //의존성 개수
            c = Integer.parseInt(st.nextToken()); //해킹당한 컴퓨터 번호

            ans = solve(n,d,c);
            sb.append(ans[0]).append(" ").append(ans[1]).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int[] solve(int n,int d,int c) throws IOException {
        int i=0,j=0,a=0,b=0,s=0;
        int[] infectionTime = new int[n+1];
        List<List<Info>> virusMap = new ArrayList<>();

        PriorityQueue<Info> pq = new PriorityQueue<>();
        Arrays.fill(infectionTime,Integer.MAX_VALUE);
        pq.add(new Info(c,0));
        infectionTime[c] = 0;

        for(i=0;i<=n;i++)
            virusMap.add(new ArrayList<>());

        for(i=0;i<d;i++){
            st = new StringTokenizer(br.readLine());

            a = Integer.parseInt(st.nextToken()); //slave
            b = Integer.parseInt(st.nextToken()); //master
            s = Integer.parseInt(st.nextToken()); //time
            virusMap.get(b).add(new Info(a,s));
        }

        while(!pq.isEmpty())
        {
            Info virus = pq.poll();

            a = virus.slave;
            s = virus.time;

            if(s>infectionTime[a])
                continue;

            for(Info slaveInfo : virusMap.get(a)){
                if(slaveInfo.time+s < infectionTime[slaveInfo.slave]){
                    infectionTime[slaveInfo.slave] = slaveInfo.time+s;
                    pq.add(new Info(slaveInfo.slave, infectionTime[slaveInfo.slave]));
                }
            }
        }
        return getMax(infectionTime);
    }
    public static int[] getMax(int[] arr){
        int[] ans = new int[2];
        int count=0,max=0;
        for(int i=1;i<arr.length;i++){
            if(arr[i] == Integer.MAX_VALUE)
                continue;
           else{
               if(max < arr[i])
                   max = arr[i];
               count++;
            }
        }
        ans[0] = count;
        ans[1] = max;
        return ans;
    }
}

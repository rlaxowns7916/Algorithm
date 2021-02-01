package 백준.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    public static int N = 0;
    public static PriorityQueue<Integer> pq = new PriorityQueue<>();
    public static void main(String[] args) throws IOException {
        int i=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for(i=0;i<N;i++)
            pq.add(Integer.parseInt(br.readLine()));

        System.out.println(solve());
    }
    public static int solve()
    {
        int first=0,second=0,next=0,total=0;

        if(pq.size()>1){
            while(!pq.isEmpty()){
                first = pq.poll();
                second = pq.poll();
                total += next = first+second;
                if(pq.isEmpty())
                    break;
                pq.add(next);
            }
        }
        return total;
    }
}

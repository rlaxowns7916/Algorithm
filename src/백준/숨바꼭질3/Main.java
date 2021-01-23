package 백준.숨바꼭질3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main{
    public static int N=0,K=0;
    public static class Info{
        int pos;
        int time;

        public Info(int pos,int time){
            this.pos = pos;
            this.time = time;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        System.out.println(solve());
    }
    public static int solve()
    {
        Deque<Info> dq = new LinkedList();
        boolean[] visit = new boolean[100001];
        int nowTime=0,nowPos=0;
        dq.addFirst(new Info(N,0));
        visit[N] = true;

        while(!dq.isEmpty())
        {
            Info now = dq.poll();
            nowTime = now.time;
            nowPos = now.pos;

            if(nowPos == K)
                break;
            else{
                if(nowPos*2 <= 100000 && !visit[nowPos*2]){
                    dq.addFirst(new Info(nowPos*2,nowTime));
                    visit[nowPos*2]=true;
                }
                if(nowPos+1<=100000 && !visit[nowPos+1]){
                    dq.addLast(new Info(nowPos+1,nowTime+1));
                    visit[nowPos+1]=true;
                }
                if(nowPos -1 >=0 && !visit[nowPos-1]){
                    dq.addLast(new Info(nowPos-1,nowTime+1));
                    visit[nowPos-1]=true;
                }
            }
        }
        return nowTime;
    }
}
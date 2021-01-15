package programmers.level2.프린터;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int location = Integer.parseInt(br.readLine());
        int[] priorities = new int[N];

        for(int i=0;i<N;i++)
            priorities[i] = Integer.parseInt(st.nextToken());

        System.out.println(solution(priorities,location));
    }
    public static int solution(int[] priorities,int location)
    {
       LinkedList<Point> queue = new LinkedList<>();
       int i=0,j=0,length = priorities.length,ans=1;

       for(i=0;i<length;i++)
           queue.add(new Point(priorities[i],i));

       while(!queue.isEmpty())
       {
           Point temp = queue.poll();
           boolean flag = false;
           for(i=0;i<queue.size() && !flag;i++)
           {
               if(temp.priority<queue.get(i).priority){
                   queue.addLast(temp);
                   flag = true;
               }
           }
           if(!flag)
           {
               if(temp.location == location)
                   break;
               else
                   ans++;
           }
       }
        return ans;
    }
}
class Point
{
    int priority;
    int location;

    public Point(int priority,int location)
    {
        this.priority = priority;
        this.location = location;
    }
}

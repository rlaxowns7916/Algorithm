package programmers.level2.두큐합같게만들기;

import java.util.LinkedList;
import java.util.Queue;

public class Main {
    boolean isFind =false;
    int answer = 0,p1=0,p2=0;
    public long solution(int[] queue1, int[] queue2) {
        long sum1=0, sum2=0,len = queue1.length;
        long answer = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i=0;i<len;i++){
            sum1 += queue1[i];
            sum2 += queue2[i];

            q1.add(queue1[i]);
            q2.add(queue2[i]);
        }

        if((sum1 + sum2) % 2 == 0){
            while(p1 < len * 2 && p2 < len * 2){
                if(sum1 == sum2){
                    return answer;
                }else if(sum1 < sum2){
                    p2++;
                    int poll = q2.poll();
                    sum1 += poll;
                    sum2 -= poll;
                    q1.add(poll);
                }else{
                    p1++;
                    int poll = q1.poll();
                    sum1 -= poll;
                    sum2 += poll;
                    q2.add(poll);
                }
                answer++;
            }
        }
        return -1;
    }
}

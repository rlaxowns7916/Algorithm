package programmers.level2.기능개발;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine()), i = 0;
        int[] progresses = new int[n];
        int[] speeds = new int[n];
        int[] answer;
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < n; i++)
            progresses[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (i = 0; i < n; i++)
            speeds[i] = Integer.parseInt(st.nextToken());

        answer = solution(progresses, speeds);

        for (int num : answer)
            System.out.println(num);
    }

    public static int[] solution(int[] progresses, int[] speeds) {
        int length = progresses.length,total = 0,nextCounter=0,count=0;
        boolean[] check = new boolean[length];
        ArrayList<Integer> ans = new ArrayList<>();
        int[] answer;

        while(total != length){
            count = 0;
            for(int i=0;i<length && !check[i];i++)
                progresses[i] += speeds[i];

            while(nextCounter != length){
                if(progresses[nextCounter] >= 100){
                    count++;
                    nextCounter++;
                }else
                    break;
            }
            if(count != 0)
                ans.add(count);
            total += count;
        }
        answer = new int[ans.size()];
        for(int i=0;i<ans.size();i++)
            answer[i] = ans.get(i);
        return answer;
    }

}

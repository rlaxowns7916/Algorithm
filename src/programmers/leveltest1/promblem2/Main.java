package programmers.leveltest1.promblem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int month=0,day=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        month = Integer.parseInt(st.nextToken());
        day = Integer.parseInt(st.nextToken());

        System.out.println(solution(month,day));
    }
    static String solution(int month,int day){
        int[] m_days = {31,29,31,30,31,30,31,31,30,31,30,31};
        String[] days ={"THU","FRI","SAT","SUN","MON","TUE","WED"};
        int sum=0;

        for(int i=0;i<month-1;i++)
            sum += m_days[i];
        sum+=day;

        return days[sum%7];
    }
}

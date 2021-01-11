package programmers.level2.구명보트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int num= Integer.parseInt(br.readLine()),limit = Integer.parseInt(br.readLine()),i=0;
        int[] peoples = new int[num];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(i=0;i<num;i++)
            peoples[i] = Integer.parseInt(st.nextToken());
        System.out.println(solution(peoples,limit));
    }
    public static int solution(int[] people,int limit) {
        int i=0,j=people.length-1,weight=0,ans=0;
        Arrays.sort(people);
        while(i<=j){
            if(people[i] + people[j] <= limit && i != j)
                i++;

            ans++;
            j--;
        }
        return ans;
    }
}

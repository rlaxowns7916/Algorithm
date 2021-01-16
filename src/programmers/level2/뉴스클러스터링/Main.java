package programmers.level2.뉴스클러스터링;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        System.out.println(solution(str1,str2));
    }
    public static int solution(String str1, String str2)
    {
        int extra=65536;
        double common=0,uncommon=0;
        ArrayList<String> multiSet1 = getMultiSet(str1.toLowerCase());
        ArrayList<String> multiSet2 = getMultiSet(str2.toLowerCase());
        //동일한 원소가 있을 때, 이미 같다고 처리한거는 뺴줘야함.
        boolean[] visit = new boolean[multiSet2.size()];

        for(int i=0;i<multiSet1.size();i++)
        {
            for(int j=0;j<multiSet2.size();j++){
                if(multiSet1.get(i).equals(multiSet2.get(j)) && !visit[j])
                {
                    common++;
                    visit[j] = true;
                    break;
                }
            }
        }
        if(multiSet1.size() == multiSet2.size() && multiSet1.size() == common)
            uncommon = 0;
        else
            uncommon = multiSet1.size()+multiSet2.size()-common;
        return uncommon==0?extra:(int)((common/uncommon)*extra);
    }
    public static ArrayList<String> getMultiSet(String str)
    {
        int i=0,j=0;
        ArrayList<String> multiSet = new ArrayList<>();
        for(i=0;i<str.length()-1;i++) {
            String set = str.substring(i,i+2);
            boolean flag=true;
            for(j=0;j<2 && flag;j++) {
                char tmp = set.charAt(j);
                if(tmp<'a' || tmp>'z')
                    flag = false;
           }
           if(flag)
               multiSet.add(set);
        }
        return multiSet;
    }
}

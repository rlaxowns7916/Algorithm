package programmers.level2.스킬트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String skill = br.readLine();
        String[] skill_tress = new String[n];

        for(int i=0;i<n;i++)
            skill_tress[i] = br.readLine();

        System.out.println(solution(skill,skill_tress));

    }
    public static int solution(String skill,String[] skill_tress)
    {
        int total=0,number = skill.length();
        String[] subsets = new String[number+1];
        String alphabet =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        boolean[] mainSkill = new boolean[26];

        //주요 선행스킬만 체크
        for(int i=0;i<number;i++)
            mainSkill[alphabet.indexOf(skill.charAt(i))]=true;

        //필요없는 스킬들 날림
        for(int i=0;i<skill_tress.length;i++)
            skill_tress[i] = compressString(skill_tress[i],mainSkill,alphabet);

        getSubset(subsets,skill);
        for(String skill_tree : skill_tress){
            if(skill_tree.equals(subsets[skill_tree.length()]))
                total++;
        }
        return total;
    }
    public static void getSubset(String[] subset,String skill)
    {
        String strCopy="";
        subset[0]=strCopy;

        for(int i=0;i<skill.length();i++){
        strCopy += skill.charAt(i);
        subset[i+1]=strCopy;
    }

    }
    public static String compressString(String str,boolean[] mainSkill,String alphabet){
        String ret="";

        for(int i=0;i<str.length();i++){
            if(mainSkill[alphabet.indexOf(str.charAt(i))])
                ret+=str.charAt(i);
        }
        return ret;
    }
}

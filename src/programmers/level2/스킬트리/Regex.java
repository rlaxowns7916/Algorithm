package programmers.level2.스킬트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Regex {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String base = br.readLine();
        String[] strArr = new String[n];

        for(int i=0;i<n;i++){
            strArr[i] = br.readLine();
        }

        for(int i=0;i<n;i++){
            //base에 있는 문자를 제외하고 한문자를 찾는다.
            String newStr = strArr[i].replaceAll("[^" + base +"]","");
            System.out.println(newStr);
        }
    }
}

package programmers.level2.전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        String[] phone_book = new String[n];

        for(int i=0;i<n;i++)
            phone_book[i] = st.nextToken();

        System.out.println(solution(phone_book));
    }
    public static boolean solution(String[] phone_book)
    {
        int i=0,j=0;
        boolean ans = true;

        Arrays.sort(phone_book);

        for(i=0;i<phone_book.length-1 && ans;i++){
            if(phone_book[i+1].startsWith(phone_book[i]))
                ans = false;
        }
        return ans;
    }
}

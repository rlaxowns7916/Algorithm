package 백준.캠핑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int L=0,P=0,V=0,count=1;

        while(true){
            st = new StringTokenizer(br.readLine());

            //연속하는 P일중에 L일만 사용가능하다. V는 휴가의 총일수
            L = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            V = Integer.parseInt(st.nextToken());

            if(L == 0 && P == 0 && V == 0)
                break;
            sb.append("Case ").append(count++).append(": ").append(solve(L,P,V)).append("\n");
        }
        System.out.println(sb.toString());
    }
    public static int solve(int L,int P,int V)
    {
        int remain = L<V%P?L:V%P;
        return L*(V/P)+ remain;
    }
}

package 백준.주사위;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    /**
     * 3개 보이는면, 2개보이는면, 1개보이는면 존재
     * 요걸 계산해서 곱하면 될듯
     *
     * 3개보이는면 --> 무조건 4개
     * 1개보이는면 --> (N-2) * (N-2)
     * 2개보이는면 --> 나머지
     * 0개 보이는면 --> 노출안되는면 + 맨 밑면 테두리빼고
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        long dimension3Count=0, dimension2Count=0, dimension1Count=0, dimension0Count=0;
        long dimension3=0, dimension2=Long.MAX_VALUE, dimension1=Long.MAX_VALUE;
        long answer = 0, total = N * N * N;

        int[] dices = new int[6];
        int max=0, sum =0;

        StringTokenizer st = new StringTokenizer(br.readLine());
        dimension0Count = N > 2 ? (N-2) * (N-2) * (N-2) + (N-2) * (N-2) : 0;
        dimension3Count = 4;
        dimension1Count = N > 2 ? ((N-2) * (N-2) * 5L + (N-2) * 4L) : 0;
        dimension2Count = total - (dimension3Count + dimension1Count + dimension0Count);


        for (int i = 0; i < 6; i++) {
            dices[i] = Integer.parseInt(st.nextToken());

            max = Math.max(dices[i],max);
            sum += dices[i];
        }

        if(N == 1){
            System.out.print(sum - max);
            return;
        }


        for(int i =0; i< 6; i++){
            dimension1 = Math.min(dimension1, dices[i]);
        }
        answer += dimension1Count * dimension1;


        for(int i=0; i<6; i++){
            for(int j=0; j<6; j++){
                if(i != j && i+j != 5){
                    dimension2 = Math.min(dimension2, dices[i] + dices[j]);
                }
            }
        }
        answer += dimension2Count * dimension2;

        for (int i = 0; i < 3; i++) {
            dimension3 += Math.min(dices[i], dices[5 - i]);
        }
        answer += dimension3Count * dimension3;


        System.out.print(answer);
    }
}

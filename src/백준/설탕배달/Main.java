package 백준.설탕배달;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int answer = 0, N = Integer.parseInt(br.readLine());
        int[] sugars = new int[N + 1];

        if(N >= 3){
            sugars[3] = 1;
        }
        if(N >= 5){
            sugars[5] = 1;
        }

        for(int i = 3; i<= N; i++){
            if(sugars[i] != 0){
                if(i +3 <= N){
                    sugars[i+3] = sugars[i+3] == 0 ? sugars[i] + 1 : Math.min(sugars[i+3], sugars[i] + 1);
                }

                if(i + 5 <= N){
                    sugars[i+5] = sugars[i+5] == 0 ? sugars[i] + 1 : Math.min(sugars[i+5], sugars[i] + 1);
                }
            }
        }

        answer = sugars[N] == 0 ? -1 : sugars[N];
        System.out.println(answer);
    }
}

package 백준.모든순열;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] numbers = new int[N];
        boolean[] visit = new boolean[N];
        StringBuilder sb = new StringBuilder();

        solve(0,numbers,visit, sb);
        System.out.println(sb);

    }

    private static void solve(int depth, int[] numbers, boolean[] visit,StringBuilder answer){
        if(depth == numbers.length){
            for(int number : numbers){
                answer.append(number).append(" ");
            }
            answer.append("\n");
        }else{
            for(int i = 0; i<numbers.length;i++){
                if(!visit[i]){
                    visit[i] = true;
                    numbers[depth] = i+1;
                    solve(depth+1,numbers,visit,answer);
                    visit[i]=false;
                }
            }
        }
    }
}

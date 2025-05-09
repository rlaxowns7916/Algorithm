package 백준.행복유치원;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    /**
     * 인접 한 것들끼리 비교하면 될 듯 하다. (Greedy)
     * 1 3 4 6 9 10 11
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int answer=0;
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] children = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] diffs = new int [N-1];

        for(int i=0; i<N-1; i++){
            diffs[i] = children[i+1] - children[i];
        }
        Arrays.sort(diffs);


        for(int i=0; i < N-K; i++){
            answer += diffs[i];
        }


        System.out.print(answer);
    }
}

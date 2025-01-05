package 백준.DNA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int N=0, M=0, dist = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        String[] dnas = new String[N];

        for(int i=0;i<N;i++){
            dnas[i] = br.readLine();
        }


        for(int i=0;i<M;i++){
            int index = 0;
            int min = Integer.MIN_VALUE;
            int[] alphabets = new int[26];

            for(int j=0;j<N;j++){
                alphabets[dnas[j].charAt(i) - 'A']++;
            }

            for(int j=0;j<26;j++){
                if(alphabets[j] > min){
                    index = j;
                    min = alphabets[j];
                }
            }
            sb.append((char)('A'+index));
            dist += N - min;
        }
        sb.append("\n").append(dist);
        System.out.println(sb);
    }
}
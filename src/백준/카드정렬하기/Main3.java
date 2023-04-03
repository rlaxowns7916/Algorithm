package 백준.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main3{
    public static int N=0;
    public static void main(String[] args) throws IOException {
        int result=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        N = Integer.parseInt(br.readLine());

        for(int i=0;i<N;i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        while(true){
            int tmp =0;
            if(pq.size() == 1){
                break;
            }else{
                int num1 = pq.poll();
                int num2 = pq.poll();

                tmp = num1+num2;
                result += tmp;
                pq.add(tmp);
            }
        }
        System.out.println(result);
    }
}
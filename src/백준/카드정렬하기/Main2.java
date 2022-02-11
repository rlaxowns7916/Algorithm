package 백준.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main2 {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        int sum = 0, num1 = 0, num2 = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i < N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        while (!pq.isEmpty()) {
            num1 = pq.poll();
            if (pq.isEmpty())
                break;
            num2 = pq.poll();
            sum += num1 + num2;
            pq.add(num1 + num2);
        }
        System.out.println(sum);
    }
}

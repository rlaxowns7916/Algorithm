package 백준.카드정렬하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Main3 {
    public static int N = 0;
    public static List<Integer> numbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++)
            numbers.add(Integer.parseInt(br.readLine()));
        System.out.println(sum());
    }

    public static int sum() {
        int num1 = 0, num2 = 0, sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.addAll(numbers);

        while (true) {
            num1 = pq.poll();
            if (pq.isEmpty())
                break;
            num2 = pq.poll();
            sum += (num1 + num2);
            pq.add(num1 + num2);
        }
        return sum;
    }
}

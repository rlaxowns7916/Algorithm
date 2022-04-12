package 백준.크게만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main2 {
    public static int max = Integer.MIN_VALUE;
    public static int N = 0, K = 0;
    public static int[] numbers;

    public static void main(String[] args) throws IOException {
        int deletionCount = 0, i = 0;
        StringBuilder sb = new StringBuilder();
        Deque<Integer> deque = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        String input = br.readLine();

        for (i = 0; i < N; i++) {
            int number = input.charAt(i) - '0';

            if (deletionCount == K)
                deque.addLast(number);
            else if (deque.isEmpty())
                deque.addLast(number);
            else if (deque.peekLast() < number) {
                while (!deque.isEmpty() && deletionCount < K) {
                    if (deque.peekLast() < number) {
                        deque.removeLast();
                        deletionCount++;
                    } else
                        break;
                }
                deque.addLast(number);
            } else if (deque.size() < N - K)
                deque.addLast(number);
        }
        while (!deque.isEmpty())
            sb.append(deque.removeFirst());
        System.out.println(sb);
    }
}
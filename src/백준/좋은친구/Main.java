package 백준.좋은친구;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, K = 0;

    public static void main(String[] args) throws IOException {
        int len = 0;
        long count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Queue<Integer>[] queue = new Queue[21];

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= 20; i++)
            queue[i] = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            len = input.length();

            if (queue[len].isEmpty())
                queue[len].add(i);
            else {
                while (!queue[len].isEmpty()) {
                    if (i - queue[len].peek() > K)
                        queue[len].poll();
                    else {
                        count += queue[len].size();
                        break;
                    }
                }
                queue[len].add(i);
            }
        }
        System.out.println(count);
    }
}

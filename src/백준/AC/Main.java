package 백준.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static int T = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean dir = true;
            boolean isError = false;
            Deque<Integer> dequeue = new LinkedList<>();
            String input = br.readLine();
            int len = Integer.parseInt(br.readLine());
            String numbers = br.readLine();
            StringTokenizer st = new StringTokenizer(numbers.substring(1, numbers.length() - 1), ",");

            for (int i = 0; i < len; i++)
                dequeue.addLast(Integer.parseInt(st.nextToken()));
            for (int i = 0; i < input.length(); i++) {
                if (input.charAt(i) == 'D') {
                    if (dequeue.size() == 0) {
                        isError = true;
                        break;
                    } else {
                        if (dir) {
                            dequeue.removeFirst();
                        } else {
                            dequeue.removeLast();
                        }
                    }
                } else {
                    dir = !dir;
                }
            }
            if (isError) {
                sb.append("error").append("\n");
            } else {
                sb.append("[");
                if (dequeue.size() > 0) {
                    if (dir) {
                        while (dequeue.size() > 0)
                            sb.append(dequeue.removeFirst()).append(",");
                    } else {
                        while (dequeue.size() > 0)
                            sb.append(dequeue.removeLast()).append(",");
                    }
                    sb.replace(sb.length() - 1, sb.length(), "]");
                } else
                    sb.append("]");
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}

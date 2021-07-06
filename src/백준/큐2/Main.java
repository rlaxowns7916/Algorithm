package 백준.큐2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int n = 0;
    public static Queue queue;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuffer sb = new StringBuffer();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        queue = new Queue(n + 1);
        int result = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            if (st.countTokens() == 2)
                result = calculate(st.nextToken(), Integer.parseInt(st.nextToken()));
            else
                result = calculate(st.nextToken(), null);
            if (result != -2)
                sb.append(result).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int calculate(String command, Integer num) {
        if (command.charAt(0) == 'p') {
            if (command.charAt(1) == 'u') {

                queue.arr[queue.tail++] = num;
                queue.count++;
                return -2;
            } else {
                if (queue.count == 0)
                    return -1;
                queue.count--;
                return queue.arr[queue.head++];
            }
        } else if (command.charAt(0) == 's') {
            return queue.count;
        } else if (command.charAt(0) == 'e') {
            return queue.count == 0 ? 1 : 0;
        } else if (command.charAt(0) == 'f') {
            return queue.count == 0 ? -1 : queue.arr[queue.head];
        } else {
            return queue.count == 0 ? -1 : queue.arr[queue.tail - 1];
        }
    }
}

class Queue {
    int head;
    int tail;
    int count;
    int[] arr;

    public Queue(int num) {
        arr = new int[num];
        count = head = tail = 0;
    }
}
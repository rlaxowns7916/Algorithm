package 백준.수묶기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[N];

        for (int i = 0; i < N; i++)
            numbers[i] = Integer.parseInt(br.readLine());

        Arrays.sort(numbers);
        System.out.println(solve(numbers));
    }

    public static int solve(int[] numbers) {
        int sum = 0;
        int used = 0, next = 0;
        int len = numbers.length;

        while (true) {
            if (used >= len)
                break;
            next = used + 1;
            if (numbers[used] < 0) {
                if (next < len) {
                    if (numbers[next] < 0) {
                        sum += numbers[used] * numbers[next];
                        used = next;
                    } else if (numbers[next] == 0)
                        used = next;
                    else
                        sum += numbers[used];
                } else
                    sum += numbers[used];
                used++;
            } else
                break;
        }
        used = len - 1;

        while (true) {
            if (used < 0)
                break;
            next = used - 1;
            if (numbers[used] > 0) {
                if (next >= 0) {
                    if (numbers[next] > 1) {
                        sum += numbers[used] * numbers[next];
                        used = next;
                    } else
                        sum += numbers[used];
                } else
                    sum += numbers[used];
                used--;
            } else
                break;
        }
        return sum;
    }
}

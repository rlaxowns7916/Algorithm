package 백준.곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int A = 0, B = 0, C = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        System.out.println(func(B) % C);
    }

    public static long func(int index) {
        if (index == 0)
            return 0;
        else if (index == 1)
            return A;
        else
            return calc(index, func(index / 2));
    }

    public static long calc(int index, long value) {
        if (index % 2 == 0)
            return (value * value) % C;
        else
            return (((value * value) % C) * A) % C;
    }
}

package 백준.피보나치함수;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] zero = new int[41], one = new int[41];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int i = 0, testCase = Integer.parseInt(br.readLine()), num = 0;

        for (i = 0; i < testCase; i++) {
            num = Integer.parseInt(br.readLine());
            sb.append(getZeroFunctionCall(num)).append(" ").append(getOneFunctionCall(num)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int getZeroFunctionCall(int num) {
        if (num >= 0) {
            if (zero[num] != 0)
                return zero[num];
            else if (num == 0 || num == 1)
                if (num == 0)
                    return 1;
                else
                    return 0;
            else
                return zero[num] = getZeroFunctionCall(num - 1) + getZeroFunctionCall(num - 2);
        } else
            return 0;
    }

    public static int getOneFunctionCall(int num) {
        if (num >= 1) {
            if (one[num] != 0)
                return one[num];
            else if (num == 0 || num == 1)
                if (num == 1)
                    return 1;
                else
                    return 0;
            else
                return one[num] = getOneFunctionCall(num - 1) + getOneFunctionCall(num - 2);
        } else
            return 0;
    }
}

package 백준.AtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = 0, B = 0, count = 1;

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        while (A != B) {
            if (A > B) {
                System.out.println(-1);
                return;
            } else {
                if (B % 2 == 0) {
                    B /= 2;
                    count++;
                } else {
                    String numberString = String.valueOf(B);
                    int numberLen = numberString.length();

                    if (numberString.charAt(numberLen - 1) != '1') {
                        System.out.println(-1);
                        return;
                    } else {
                        numberString = numberString.substring(0, numberLen - 1);
                        B = Integer.parseInt(numberString);
                        count++;
                    }
                }
            }
        }
        System.out.println(count);
    }
}

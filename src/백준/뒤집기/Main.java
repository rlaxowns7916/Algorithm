package 백준.뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] count = new int[2];
        String input = br.readLine();

        count[input.charAt(0) - '0']++;
        for (int i = 1; i < input.length(); i++) {
            if (input.charAt(i - 1) != input.charAt(i))
                count[input.charAt(i) - '0']++;
        }
        System.out.println(Math.min(count[0], count[1]));
    }
}

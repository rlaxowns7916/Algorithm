package 백준.A와B;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean[] a;
    public static boolean[] b;

    public static void main(String[] args) throws IOException {
        int i = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine(), str2 = br.readLine();

        a = new boolean[str2.length()];
        b = new boolean[str2.length()];

        for (i = 0; i < str1.length(); i++)
            a[i] = str1.charAt(i) == 'A';
        for (i = 0; i < str2.length(); i++)
            b[i] = str2.charAt(i) == 'A';
        System.out.println(solve(str1.length() - 1, str2.length() - 1));
    }

    public static int solve(int len1, int len2) {
        while (len2 > len1) {
            if (!b[len2]) {
                swap(len2);
            }
            len2--;
        }
        for (int i = 0; i <= len1; i++) {
            if (a[i] != b[i])
                return 0;
        }
        return 1;
    }

    public static void swap(int now) {
        boolean temp;
        for (int i = 0; i < now / 2; i++) {
            temp = b[now - 1 - i];
            b[now - 1 - i] = b[i];
            b[i] = temp;
        }
    }
}

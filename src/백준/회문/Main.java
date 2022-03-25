package 백준.회문;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        while (N-- > 0)
            sb.append(solve(br.readLine())).append("\n");
        System.out.println(sb);
    }

    public static int solve(String input) {
        int answer = 0;
        boolean isSimilarPalindrome = false, leftExceptPalindrome = false, rightExceptPalindrome = false;
        int len = input.length(), left = 0, right = len - 1;

        while (left <= right) {
            if (input.charAt(left) != input.charAt(right)) {
                leftExceptPalindrome = isPalindrome(input.substring(left + 1, right + 1));
                rightExceptPalindrome = isPalindrome(input.substring(left, right));

                if (!leftExceptPalindrome && !rightExceptPalindrome)
                    return 2;
                else {
                    if (leftExceptPalindrome)
                        left++;
                    if (rightExceptPalindrome)
                        right--;
                    isSimilarPalindrome = true;
                }
            } else {
                left++;
                right--;
            }
        }
        if (isSimilarPalindrome)
            return 1;
        else
            return 0;
    }

    public static boolean isPalindrome(String input) {
        int len = input.length(), left = 0, right = len - 1;

        while (left <= right) {
            if (input.charAt(left++) != input.charAt(right--))
                return false;
        }
        return true;
    }
}

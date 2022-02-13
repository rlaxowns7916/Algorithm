package programmers.level3.정수삼각형;

public class Main {
    public static void main(String[] args) {
        int[][] input = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(input));
    }

    public static int solution(int[][] triangle) {
        int max = 0;
        int len = triangle.length;
        int[][] dp = new int[len + 1][len + 1];
        dp[0][0] = triangle[0][0];
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (j == i) {
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + triangle[i][j];
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (max < dp[len - 1][i])
                max = dp[len - 1][i];
        }
        return max;
    }
}

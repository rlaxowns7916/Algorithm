package 백준.행렬제곱;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static long B = 0;
    public static long[][] matrix;
    public static long[][] unitMatrix;

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        long[][] ans;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        matrix = new long[N + 1][N + 1];
        unitMatrix = new long[N + 1][N + 1];
        for (i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 1; j <= N; j++)
                matrix[i][j] = Integer.parseInt(st.nextToken()) % 1000;
        }
        for (i = 1; i <= N; i++)
            unitMatrix[i][i] = 1;
        ans = func(B);

        for (i = 1; i <= N; i++) {
            for (j = 1; j <= N; j++)
                sb.append(ans[i][j] % 1000).append(" ");
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static long[][] func(long level) {
        if (level == 0)
            return unitMatrix;
        else if (level == 1)
            return matrix;
        else
            return calculate(level, func(level / 2));
    }

    public static long calculateIndex(long[][] matrix1, long[][] matrix2, int row, int col) {
        int i = 0, ans = 0;
        for (i = 1; i <= N; i++)
            ans += (matrix1[row][i] * matrix2[i][col]) % 1000;
        return ans;
    }

    public static long[][] calculate(long index, long[][] subMatrix) {
        return index % 2 == 0 ? evenCalculate(index, subMatrix) : oddCalculate(evenCalculate(index, subMatrix));
    }

    public static long[][] oddCalculate(long[][] subMatrix) {
        long[][] ans = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                ans[i][j] = calculateIndex(subMatrix, matrix, i, j);
        }
        return ans;
    }

    public static long[][] evenCalculate(long index, long[][] subMatrix) {
        long[][] ans = new long[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++)
                ans[i][j] = calculateIndex(subMatrix, subMatrix, i, j);
        }
        return ans;
    }
}

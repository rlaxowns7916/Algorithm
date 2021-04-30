package 백준.Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Z {
    public static int r = 0, c = 0, count = 0;
    public static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()), len = (int) Math.pow(2, N);
        r = Integer.parseInt(st.nextToken()) + 1;
        c = Integer.parseInt(st.nextToken()) + 1;
        func(1, len, 1, len, N);
        System.out.println(count-1);
    }

    public static void func(int startX, int endX, int startY, int endY, int n) {
        int area = findArea(startX, endX, startY, endY, n), diff = (int) Math.pow(2, n - 1), midX = startX + diff-1, midY = startY + diff-1;
        if (n == 1)
            count += area;
        else {
            count += (area - 1) * diff * diff;
            if (area == 2)
                c -= diff;
            else if (area == 3)
                r -= diff;
            else if (area == 4) {
                r -= diff;
                c -= diff;
            }
            func(startX, midX, startY, midY, n - 1);
        }
    }

    public static int findArea(int startX, int endX, int startY, int endY, int n) {
        int diff = (int) Math.pow(2, n - 1), midX = startX + diff - 1, midY = startY + diff - 1;

        if (isInArea(startX, midX, startY, midY))
            return 1;
        else if (isInArea(startX, midX, midY + 1, endY))
            return 2;
        else if (isInArea(midX + 1, endX, startY, midY))
            return 3;
        else
            return 4;
    }

    public static boolean isInArea(int startX, int endX, int startY, int endY) {
        return startX <= r && r <= endX && startY <= c && c <= endY;
    }
}

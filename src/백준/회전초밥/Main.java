package 백준.회전초밥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static int n = 0, d = 0, k = 0, c = 0;
    public static ArrayList<Integer> sushis = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * 접시의 수
         */
        n = Integer.parseInt(st.nextToken());
        /**
         * 초밥의 가짓 수
         */
        d = Integer.parseInt(st.nextToken());
        /**
         * 연속해서 먹는 접시의 수
         */
        k = Integer.parseInt(st.nextToken());
        /**
         * 쿠폰번호
         */
        c = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++)
            sushis.add(Integer.parseInt(br.readLine()));
        System.out.println(solve());
    }

    public static int solve() {
        int max = 0, next = 0, before = 0, count = 0, nextIndex = 0;
        int[] visit = new int[d + 1];

        for (int i = 0; i < k; i++) {
            next = sushis.get(i);
            if (visit[next] == 0)
                count++;
            visit[next]++;
            max = visit[c] == 0 ? count + 1 : count;
        }
        for (int i = 0; i < n; i++) {
            nextIndex = (i + k) % n;
            next = sushis.get(nextIndex);
            before = sushis.get(i);

            visit[before]--;
            if (visit[before] == 0)
                count--;
            if (visit[next] == 0)
                count++;
            visit[next]++;

            if (count >= max)
                max = visit[c] == 0 ? count + 1 : count;
        }
        return max;
    }
}

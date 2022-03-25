package 백준.중량제한;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0, MAX = 1000000000;
    public static ArrayList<ArrayList<Point>> lists = new ArrayList<ArrayList<Point>>();

    static class Point {
        int to = 0;
        int cost = 0;

        public Point(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws IOException {
        int from = 0, to = 0, cost = 0;
        int start = 0, end = 0;
        int left = 1, right = MAX, mid = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i <= N; i++)
            lists.add(new ArrayList<>());
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());
            cost = Integer.parseInt(st.nextToken());

            lists.get(from).add(new Point(to, cost));
            lists.get(to).add(new Point(from, cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());


        while (left <= right) {
            mid = (left + right) / 2;
            boolean canMove = bfs(start, end, mid);

            if (canMove)
                left = mid + 1;
            else
                right = mid - 1;

        }
        System.out.println(right);
    }

    public static boolean bfs(int start, int end, int mid) {
        boolean[] visit = new boolean[N + 1];
        Queue<Point> queue = new LinkedList<>();
        visit[start] = true;
        queue.add(new Point(start, 0));

        while (!queue.isEmpty()) {
            Point now = queue.poll();

            if (now.to == end)
                return true;

            for (Point link : lists.get(now.to)) {
                if (link.cost >= mid && !visit[link.to]) {
                    queue.add(link);
                    visit[link.to] = true;
                }
            }
        }
        return false;
    }
}

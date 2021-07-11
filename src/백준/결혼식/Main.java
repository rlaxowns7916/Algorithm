package 백준.결혼식;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        int n = 0, m = 0, n1 = 0, n2 = 0;
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer>[] list;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        list = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++)
            list[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            n1 = Integer.parseInt(st.nextToken());
            n2 = Integer.parseInt(st.nextToken());

            list[n1].add(n2);
            list[n2].add(n1);
        }
        System.out.println(bfs(n, list));
    }

    public static int bfs(int n, ArrayList<Integer>[] list) {
        int now = 0, cnt = 0, next = 0, size = 0;
        boolean[] visit = new boolean[n + 1];
        Queue<Integer> queue = new LinkedList<>();

        visit[1] = true;
        queue.add(1);

        for (int i = 0; i < 2; i++) {
            size = queue.size();
            for (int j = 0; j < size; j++) {
                now = queue.poll();
                for (int k = 0; k < list[now].size(); k++) {
                    next = list[now].get(k);
                    if (!visit[next]) {
                        cnt++;
                        visit[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return cnt;
    }
}

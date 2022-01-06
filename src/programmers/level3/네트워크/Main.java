package programmers.level3.네트워크;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), i = 0, j = 0;
        int[][] computers = new int[N][N];

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++)
                computers[i][j] = Integer.parseInt(st.nextToken());
        }
        System.out.println(solution(N, computers));

    }

    public static int solution(int n, int[][] computers) {
        int i = 0, j = 0, answer = 0;
        boolean[] visit = new boolean[n];

        for (i = 0; i < n; i++) {
            if (!visit[i]) {
                BFS(i, visit, computers);
                answer++;
            }
        }

        return answer;
    }

    public static void BFS(int start, boolean[] visit, int[][] computers) {
        int i = 0, now = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visit[start] = true;
        while (!queue.isEmpty()) {
            now = queue.poll();

            for (i = 0; i < computers.length; i++) {
                if (computers[now][i] == 1 && !visit[i]) {
                    queue.add(i);
                    visit[i] = true;
                }
            }
        }
    }
}

package 백준.DSLR;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int T = 0;

    public static void main(String[] args) throws IOException {
        int now = 0, target = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());

            now = Integer.parseInt(st.nextToken());
            target = Integer.parseInt(st.nextToken());

            sb.append(solve(now, target)).append("\n");
        }
        System.out.println(sb);
    }


    public static String solve(int now, int target) {
        int nowNumber = 0;
        int D = 0, S = 0, L = 0, R = 0;
        String nowCommand = "";
        String result = "";
        Queue<Integer> numbers = new LinkedList<>();
        Queue<String> commands = new LinkedList<>();
        boolean[] visit = new boolean[100001];

        commands.add("");
        numbers.add(now);
        visit[now] = true;

        while (!numbers.isEmpty() && !commands.isEmpty()) {
            nowNumber = numbers.poll();
            nowCommand = commands.poll();
            if (nowNumber == target) {
                result = nowCommand;
                break;
            }

            D = nowNumber * 2 > 9999 ? nowNumber * 2 % 10000 : nowNumber * 2;
            S = nowNumber == 0 ? 9999 : nowNumber - 1;
            L = nowNumber % 1000 * 10 + nowNumber / 1000;
            R = nowNumber / 10 + (nowNumber % 10) * 1000;

            if (!visit[D]) {
                visit[D] = true;
                numbers.add(D);
                commands.add(nowCommand + 'D');
            }
            if (!visit[S]) {
                visit[S] = true;
                numbers.add(S);
                commands.add(nowCommand + 'S');
            }
            if (!visit[L]) {
                visit[L] = true;
                numbers.add(L);
                commands.add(nowCommand + 'L');
            }
            if (!visit[R]) {
                visit[R] = true;
                numbers.add(R);
                commands.add(nowCommand + 'R');
            }
        }
        return result;
    }
}


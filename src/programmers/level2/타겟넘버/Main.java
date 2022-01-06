package programmers.level2.타겟넘버;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static int answer = 0;

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


    }

    public static int solution(int[] numbers, int target) {
        boolean[] visit = new boolean[numbers.length];
        calc(0, numbers.length, visit, numbers, target);
        return answer;
    }

    public static void calc(int now, int depth, boolean[] visit, int[] numbers, int target) {
        if (now == depth) {
            int sum = 0;
            for (int i = 0; i < depth; i++) {
                if (visit[i])
                    sum += numbers[i];
                else
                    sum -= numbers[i];

            }
            if (sum == target)
                answer++;
        } else {
            visit[now] = true;
            calc(now + 1, depth, visit, numbers, target);
            visit[now] = false;
            calc(now + 1, depth, visit, numbers, target);
        }
    }
}

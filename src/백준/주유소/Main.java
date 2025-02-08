package 백준.주유소;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{
    /**
     * DP를 이용한 풀이
     * 각 지점을 갈 수 있을 만큼 씩 다 채워본다.
     * 그리고 MIN 연산을 통해서 결과적으로 최소한의 비용으로 목적지를 도착하는 방법을 찾는다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()), currentCost = 0;
        int[] distances = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] costs = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        long answer = 0;


        currentCost = costs[0];

        for (int i = 0; i < N - 1; i++) { // 마지막 도시는 주유할 필요 없음
            answer += (long) currentCost * distances[i]; // 현재 최소 비용으로 이동
            currentCost = Math.min(currentCost, costs[i + 1]); // 최소 기름 가격 업데이트
        }
        System.out.print(answer);
    }
}
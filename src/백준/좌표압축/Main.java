package 백준.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, List<Integer>> store = new HashMap();

        int N = Integer.parseInt(br.readLine()), i = 0, j = 0;
        int[] result = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        /**
         * Hashmap에 Value를 키값으로 중복 Count
         */
        for (i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken());
            if (!store.containsKey(value))
                store.put(value, new ArrayList<>());
            store.get(value).add(i);
        }
        /**
         * Key값으로 정렬한 리스트
         */
        List<Integer> orderedValue = store.keySet().stream().sorted((o1, o2) -> o2 - o1).collect(Collectors.toList());

        for (i = 0; i < orderedValue.size(); i++) {
            int key = orderedValue.get(i);
            for (int idx : store.get(key))
                result[idx] = orderedValue.size() - i - 1;
        }
        for (i = 0; i < N; i++)
            sb.append(result[i]).append(" ");

        System.out.println(sb.toString());
    }
}


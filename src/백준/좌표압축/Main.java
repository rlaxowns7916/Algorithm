package 백준.좌표압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Integer, Integer> dup = new HashMap<>();

        int N = Integer.parseInt(br.readLine()), i = 0, cnt = 0;
        int[] origin = new int[N], copy;

        st = new StringTokenizer(br.readLine());

        for (i = 0; i < N; i++)
            origin[i] = Integer.parseInt(st.nextToken());
        copy = origin.clone();
        Arrays.sort(copy);

        for (i = 0; i < N; i++) {
            if (!dup.containsKey(copy[i]))
                dup.put(copy[i], cnt++);
        }
        for (i = 0; i < N; i++)
            sb.append(dup.get(origin[i])).append(" ");
        System.out.println(sb.toString());
    }
}


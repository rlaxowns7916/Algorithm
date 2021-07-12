package 백준.패션완신해빈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static Map<String, Integer> map;

    public static void main(String[] args) throws IOException {
        int T = 0, clothes = 0;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        String cloth, type;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            clothes = Integer.parseInt(br.readLine());
            map = new LinkedHashMap<>();
            for (int j = 0; j < clothes; j++) {
                st = new StringTokenizer(br.readLine());

                cloth = st.nextToken();
                type = st.nextToken();

                if (!map.containsKey(type))
                    map.put(type, 1);
                map.put(type, map.get(type) + 1);
            }
            sb.append(solve()).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int solve() {
        int res = 1;
        for (int val : map.values())
            res *= val;
        return res - 1;
    }
}

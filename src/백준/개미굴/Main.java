package 백준.개미굴;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
    public static StringBuilder sb = new StringBuilder();
    public static LinkedList<String> depth = new LinkedList<>();
    public static int level = -1;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0, N = Integer.parseInt(br.readLine()), M = 0;
        TreeMap<String, TreeMap> trie = new TreeMap<>();

        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            TreeMap<String, TreeMap> current = trie;

            for (j = 0; j < M; j++) {
                String value = st.nextToken();
                if (!current.containsKey(value))
                    current.put(value, new TreeMap<>());
                current = current.get(value);
            }
        }
        print(" ", trie);
        System.out.println(sb);
    }

    public static void print(String val, TreeMap<String, TreeMap> trie) {
        if (val != " ")
            sb.append(val).append("\n");
        if (trie.keySet().size() > 0) {
            level++;
            for (String key : trie.keySet()) {
                addDepth();
                print(key, trie.get(key));
            }
            level--;
        }
    }

    public static void addDepth() {
        for (int i = 0; i < level; i++)
            sb.append("--");
    }
}
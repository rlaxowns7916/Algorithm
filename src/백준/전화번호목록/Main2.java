package 백준.전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean flag = true;
            int numbers = Integer.parseInt(br.readLine());
            Trie tries = new Trie();

            for (int i = 0; i < numbers; i++) {
                String input = br.readLine();
                if (flag)
                    flag = tries.insert(input);
            }
            if (flag)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }

    static class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public boolean insert(String input) {
            TrieNode current = root;
            int len = input.length();
            for (int i = 0; i < len; i++) {
                int index = input.charAt(i) - '0';
                if (current.children[index] == null)
                    current.children[index] = new TrieNode();
                else if (current.children[index].isEnd || i == len - 1)
                    return false;
                current = current.children[index];
            }
            current.isEnd = true;
            return true;
        }
    }

    static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        public TrieNode() {
            isEnd = false;
            children = new TrieNode[10];
        }
    }
}

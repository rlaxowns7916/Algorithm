package 백준.접두사찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int ALPHABET_SIZE = 26;

    public static void main(String[] args) throws IOException {
        int count = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Trie trie = new Trie();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++)
            trie.insert(br.readLine());
        for (int i = 0; i < M; i++) {
            if (trie.find(br.readLine()))
                count++;
        }
        System.out.println(count);

    }

    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' ');
        }

        public boolean find(String s) {
            int len = s.length();
            TrieNode now = root;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                int idx = ch - 'a';
                if (now.children[idx] == null)
                    return false;
                now = now.children[idx];
            }
            return true;
        }

        public void insert(String s) {

            int len = s.length();
            TrieNode now = root;
            for (int i = 0; i < len; i++) {
                char ch = s.charAt(i);
                int idx = ch - 'a';
                if (now.children[idx] == null)
                    now.children[idx] = new TrieNode(ch);
                now = now.children[idx];
            }
            now.isEnd = true;
        }
    }

    static class TrieNode {
        char value;
        boolean isEnd;
        TrieNode[] children;

        public TrieNode(char value) {
            this.value = value;
            this.isEnd = false;
            this.children = new TrieNode[ALPHABET_SIZE];
        }
    }
}

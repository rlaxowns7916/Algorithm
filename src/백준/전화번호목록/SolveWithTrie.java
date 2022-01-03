package 백준.전화번호목록;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SolveWithTrie {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0, N = Integer.parseInt(br.readLine()), M = 0;
        boolean flag = true;

        for (i = 0; i < N; i++) {
            M = Integer.parseInt(br.readLine());
            Trie trie = new Trie();
            flag = true;
            for (j = 0; j < M; j++) {
                String str = br.readLine();
                if (!trie.insert(str)) {
                    flag = false;
                }
            }
            if (flag)
                sb.append("YES").append("\n");
            else
                sb.append("NO").append("\n");
        }
        System.out.println(sb);
    }
}

class Trie {
    TrieNode root;

    public Trie() {
        this.root = new TrieNode(' ');
    }

    public boolean insert(String str) {
        int length = str.length();
        TrieNode current = this.root;
        for (int i = 0; i < length; i++) {
            char chr = str.charAt(i);
            int idx = chr - '0';
            if (current.children[idx] == null)
                current.children[idx] = new TrieNode(chr);
            else if (current.children[idx].isEnd || (!current.isEnd && i == length - 1))
                return false;
            current = current.children[idx];
        }
        current.setEnd();
        return true;
    }
}

class TrieNode {
    final int NUMSIZE = 10;
    TrieNode[] children;
    char val;
    boolean isEnd = false;

    public TrieNode(char val) {
        this.children = new TrieNode[NUMSIZE];
        this.val = val;
    }

    public void setEnd() {
        this.isEnd = true;
    }
}
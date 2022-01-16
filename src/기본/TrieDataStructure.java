package 기본;

/**
 * 문자열을 효율적으로 저장하고 탐색하는 자료구조
 * 문자 하나당의 트리구조
 * 문자열 길이 만큼의 O(N)의 시간복잡도를 가짐
 */
public class TrieDataStructure {
    /**
     * 대문자만 받는다고 가정
     */
    public static int ALPHABET_SIZE = 26;

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("HELLO");
        trie.insert("GOODBYE");

        print(trie.root, "");
    }

    public static void print(TrieNode node, String str) {
        for (int i = 0; i < ALPHABET_SIZE; i++) {
            if (node.children[i] != null) {
                String newStr = str + (char) (i + 'A');
                if (node.children[i].isFinish)
                    System.out.println(newStr);
                else
                    print(node.children[i], newStr);
            }
        }
    }
    static class Trie {
        TrieNode root;

        public Trie() {
            this.root = new TrieNode(' ');
        }

        public void insert(String s) {
            TrieNode now = root;
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                int idx = ch - 'A';

                if (now.children[idx] == null)
                    now.children[idx] = new TrieNode(ch);
                now = now.children[idx];
            }
            now.isFinish = true;
        }
    }

    static class TrieNode {
        char value;
        boolean isFinish;
        TrieNode[] children;

        public TrieNode(char value) {
            this.value = value;
            this.isFinish = false;
            this.children = new TrieNode[26];
        }
    }
}

package 백준.이진검색트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int val;
        Node left;
        Node right;

        public Node(int val) {
            this.val = val;
        }
    }

    static class Tree {
        Node root;

        public Tree(int val) {
            this.root = new Node(val);
        }

        public void insert(int val) {
            Node current = root;
            while (true) {
                if (val < current.val) {
                    if (current.left == null) {
                        current.left = new Node(val);
                        break;
                    } else
                        current = current.left;
                } else {
                    if (current.right == null) {
                        current.right = new Node(val);
                        break;
                    } else
                        current = current.right;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int root = Integer.parseInt(br.readLine());
        Tree tree = new Tree(root);

        while (true) {
            String input = br.readLine();
            if (input == null || input.equals("") || input.equals("\n"))
                break;
            tree.insert(Integer.parseInt(input));
        }
        print(tree.root, sb);
        System.out.println(sb);

    }

    public static void print(Node current, StringBuilder sb) {
        if (current.left != null)
            print(current.left, sb);
        if (current.right != null)
            print(current.right, sb);
        sb.append(current.val).append("\n");
    }
}

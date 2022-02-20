package 백준.트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int delete = Integer.parseInt(br.readLine()), count = 0;
        nodes = new Node[N];

        for (int i = 0; i < N; i++)
            nodes[i] = new Node();
        for (int i = 0; i < N; i++) {
            int parent = Integer.parseInt(st.nextToken());
            if (parent >= 0)
                nodes[parent].children.add(i);
            nodes[i].parent = parent;
        }
        removeTree(delete);
        for (int i = 0; i < N; i++) {
            if (!nodes[i].isDelete && nodes[i].children.isEmpty())
                count++;
        }
        System.out.println(count);
    }

    public static void removeTree(int idx) {
        if (nodes[idx].parent >= 0)
            nodes[nodes[idx].parent].delete(idx);
        nodes[idx].isDelete = true;
        for (int i = 0; i < N; i++) {
            if (nodes[i].parent == idx) {
                removeTree(i);
            }
        }
    }

    static class Node {
        int parent = -1;
        boolean isDelete;
        List<Integer> children;

        public Node() {
            this.isDelete = false;
            this.children = new ArrayList<>();
        }

        public void delete(int idx) {
            int size = children.size();
            for (int i = 0; i < size; i++) {
                if (children.get(i) == idx) {
                    children.remove(i);
                    break;
                }
            }
        }
    }
}

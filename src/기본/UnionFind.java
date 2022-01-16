package 기본;

/**
 * 두개의 노드를 같은 집합으로 묶어주고
 * 다시 두 노드가 같은 집합에 속해 있는지 확인해주는 알고리즘
 */
public class UnionFind {
    public static int[] parent;
    public static int[] rank;

    public static void main(String[] args) {

    }

    /**
     * 최초 Initialize 시에, 자기 자신을 부모로 세팅
     * 트리의 높이를 저장하기 위해 트리의 높이를 1로 세팅
     */
    public static void init(int n) {
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    /**
     * Root 부모 노드를 찾는 알고리즘
     */
    public static int find(int target) {
        /**
         * 본인이 RootNode일 경우 자기 자신 리턴
         */
        if (parent[target] == target)
            return target;
        /**
         * 부모를 계속 타고올라가면서 RootNode 탐색
         * Depth를 낮추기 위해서, 부모노드를 찾은 노드로 갱신
         */
        else
            return parent[target] = find(parent[target]);
    }

    /**
     * 두 노드를 한 집합으로 합쳐주는 알고리즘
     * 작은 트리를 큰 트리 밑으로 붙임
     * 높이가 같을 때는 합친 대상의 Rank를 1단계 올려줌
     */
    public static void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y)
            return;
        if (rank[x] < rank[y])
            parent[x] = y;
        else
            parent[y] = x;
        if (rank[x] == rank[y])
            rank[x]++;
    }
}

package 백준.특정한최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0, E = 0;

    public static class Route implements Comparable<Route> {
        int target = 0;
        int distance = 0;

        public Route(int target, int distance) {
            this.target = target;
            this.distance = distance;
        }

        @Override
        public int compareTo(Route o) {
            return this.distance - o.distance;
        }
    }
    public static List<List<Route>> Map = new ArrayList<>();
    public static List<Integer> mustPass = new ArrayList<>();
    public static int INF = 8000001;

    public static void main(String[] args) throws IOException {
        int start = 0, end = 0, distance = 0, i = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        for (i = 0; i <= N; i++)
            Map.add(new ArrayList<>());

        for (i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());

            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            distance = Integer.parseInt(st.nextToken());

            Map.get(start).add(new Route(end, distance));
            Map.get(end).add(new Route(start,distance));
        }
        st = new StringTokenizer(br.readLine());
        for (i = 0; i < 2; i++)
            mustPass.add(Integer.parseInt(st.nextToken()));

        System.out.println(func());
    }

    public static int[] dijkstra(int start) {
        int[] distance = new int[N + 1];
        int index = 0;
        PriorityQueue<Route> copy = new PriorityQueue<>();
        Arrays.fill(distance, INF);
        distance[start] = 0;
        copy.add(new Route(start, 0));

        while (!copy.isEmpty()) {
            Route temp = copy.poll();
            index = temp.target;

            for (Route token : Map.get(index)) {
                if (distance[token.target] > distance[index] + token.distance) {
                    distance[token.target] = distance[index] + token.distance;
                    copy.add(new Route(token.target, distance[token.target]));
                }
            }
        }
        return distance;
    }

    public static int func() {
        int first = mustPass.get(0), second = mustPass.get(1), ans1 = 0, ans2 = 0;
        int[] startDijkstra = dijkstra(1);
        int[] firstDijkstra = dijkstra(first);
        int[] secondDijkstra = dijkstra(second);

        ans1 = startDijkstra[first] + firstDijkstra[second] + secondDijkstra[N];
        ans2 = startDijkstra[second] + secondDijkstra[first] + firstDijkstra[N];

        if (ans1 >= INF && ans2 >= INF)
            return -1;
        else
            return Math.min(ans1, ans2);
    }
}
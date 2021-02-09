package 백준.연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0, M = 0, min = Integer.MAX_VALUE, wall = 0, empty = 0;
    public static int[][] map;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static class Point {
        int x;
        int y;
        int weight;

        public Point(int x, int y, int weight) {
            this.x = x;
            this.y = y;
            this.weight = weight;
        }
    }

    public static ArrayList<Point> enableVirus = new ArrayList();
    public static ArrayList<String> combs = new ArrayList();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, token = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (j = 0; j < N; j++) {
                token = Integer.parseInt(st.nextToken());
                if (token == 0)
                    empty++;
                else if (token == 1)
                    wall++;
                else
                    enableVirus.add(new Point(i, j, 0));
                map[i][j] = token;
            }
        }
        solve();
        min = min == Integer.MAX_VALUE ? -1 : min;
        System.out.println(min);
    }

    public static void solve() {
        boolean[] visit = new boolean[enableVirus.size()];
        comb(0, 0, visit);
        for (String comb : combs)
            min = Math.min(min, BFS(comb));
    }

    public static int BFS(String comb) {
        int count = 0, i = 0, j = 0, nx = 0, ny = 0, size = 0, virus = 0;
        boolean[][] visit = new boolean[N][N];
        Queue<Point> queue = new LinkedList();

        for (i = 0; i < comb.length(); i++) {
            Point virusLocation = enableVirus.get(comb.charAt(i) - '0');
            queue.add(virusLocation);
            visit[virusLocation.x][virusLocation.y] = true;
        }

        while (!queue.isEmpty()) {
            if (virus == empty)
                break;
            size = queue.size();
            for (i = size; i > 0; i--) {
                Point temp = queue.poll();
                for (j = 0; j < 4; j++) {
                    nx = temp.x + dx[j];
                    ny = temp.y + dy[j];
                    if (nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && map[nx][ny] != 1) {
                        if (map[nx][ny] == 0)
                            virus++;
                        visit[nx][ny] = true;
                        queue.add(new Point(nx, ny, temp.weight + 1));
                    }
                }
            }
            count++;
        }
        return virus == empty ? count : Integer.MAX_VALUE;
    }

    public static void comb(int depth, int count, boolean[] visit) {
        if (count == M || depth == visit.length) {
            if (count == M) {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < visit.length; i++) {
                    if (visit[i])
                        sb.append(i);
                }
                combs.add(sb.toString());
            }
        } else {
            visit[depth] = true;
            comb(depth + 1, count + 1, visit);
            visit[depth] = false;
            comb(depth + 1, count, visit);
        }
    }
}

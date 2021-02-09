package 백준.벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};
    public static int[][] map;
    public static int[][][] path;

    public static class Point {
        int x;
        int y;
        int wall;

        public Point(int x, int y, int wall) {
            this.x = x;
            this.y = y;
            this.wall = wall;
        }
    }
    public static void main(String[] args) throws IOException {
        int i = 0, j = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        path = new int[2][N][M];

        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < M; j++) {
                map[i][j] = str.charAt(j)-'0';
                path[0][i][j] = Integer.MAX_VALUE;
                path[1][i][j] = Integer.MAX_VALUE;
            }
        }
        System.out.println(solve());
    }

    public static int solve() {
        int i = 0, nx = 0, ny = 0,ans=0;
        Queue<Point> queue = new LinkedList();
        queue.add(new Point(0, 0, 0));
        path[0][0][0]=1;

        while (!queue.isEmpty()) {
            Point temp = queue.poll();
            if (temp.wall == 0) {
                for (i = 0; i < 4; i++) {
                    nx = temp.x + dx[i];
                    ny = temp.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M) {
                        if (map[nx][ny] == 0) {
                            if(path[0][temp.x][temp.y]+1 < path[0][nx][ny]){
                                queue.add(new Point(nx,ny,0));
                                path[0][nx][ny] = path[0][temp.x][temp.y]+1;
                            }
                        } else {
                           if(path[0][temp.x][temp.y]+1 < path[1][nx][ny]){
                               queue.add(new Point(nx,ny,1));
                               path[1][nx][ny] = path[0][temp.x][temp.y]+1;
                           }
                        }
                    }
                }
            } else {
                for (i = 0; i < 4; i++) {
                    nx = temp.x + dx[i];
                    ny = temp.y + dy[i];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0) {
                        if(path[1][temp.x][temp.y]+1 < path[1][nx][ny]){
                            path[1][nx][ny] = path[1][temp.x][temp.y]+1;
                            queue.add(new Point(nx, ny, 1));
                        }
                    }
                }
            }
        }
        ans = Math.min(path[0][N-1][M-1],path[1][N-1][M-1]);
        return ans != Integer.MAX_VALUE?ans:-1;
    }
}
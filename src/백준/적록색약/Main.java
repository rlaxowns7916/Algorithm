package 백준.적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static int N = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    enum Type {normal, abnormal}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int i = 0, j = 0, normal = 0, abnormal = 0;
        N = Integer.parseInt(br.readLine());
        char[][] Map = new char[N][N];
        for (i = 0; i < N; i++) {
            String str = br.readLine();
            for (j = 0; j < N; j++)
                Map[i][j] = str.charAt(j);
        }
        normal = solve(Map, Type.normal);
        abnormal = solve(Map, Type.abnormal);
        System.out.println(normal + " " + abnormal);
    }
    public static int solve(char[][] Map, Type type) {
        boolean[][] visit = new boolean[N][N];
        int ans = 0;
        int i = 0, j = 0;
        for (i = 0; i < N; i++) {
            for (j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    BFS(Map, type, visit, i, j);
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void BFS(char[][] Map, Type type, boolean[][] visit, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        visit[x][y] = true;
        int i = 0, j = 0, nx = 0, ny = 0;
        char color = Map[x][y];
        Point now = null;

        while(!queue.isEmpty()) {
            now = queue.poll();
            for(i=0;i<4;i++) {
                nx = now.x+dx[i];
                ny = now.y+dy[i];

                if(nx >=0 && ny>=0 && nx< N && ny < N && !visit[nx][ny]) {
                    if(type.equals(Type.normal)) {
                        if(Map[nx][ny] == color) {
                            queue.add(new Point(nx,ny));
                            visit[nx][ny]=true;
                        }
                    }else{
                        if(color == 'R' || color == 'G') {
                            if(Map[nx][ny] =='R' || Map[nx][ny] == 'G') {
                                queue.add(new Point(nx,ny));
                                visit[nx][ny]=true;
                            }
                        }else{
                            if(Map[nx][ny] == color){
                                queue.add(new Point(nx,ny));
                                visit[nx][ny]=true;
                            }
                        }
                    }
                }
            }
        }
    }
}
class Point{
    int x;
    int y;
    public Point(int x,int y) {
        this.x=x;
        this.y=y;
    }
}
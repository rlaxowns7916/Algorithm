package programmers.level2.카카오프렌즈컬러링북;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken()), n =Integer.parseInt(st.nextToken());
        int[] answer;
        int[][] picture = new int[m][n];

        for(int i=0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                picture[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = solution(m,n,picture);
        System.out.println("numberOfArea  :"+answer[0]+ "\nmaxSizeOfArea :"+answer[1]);
    }
    public static int[] solution(int m,int n,int[][] picture){
        boolean[][] visit = new boolean[m][n];
        int[] answer = new int[2];
        int numberOfArea = 0, maxSizeOfOneArea = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visit[i][j] && picture[i][j] != 0){
                    int area = BFS(picture,visit,i,j,m,n);
                    if(area>maxSizeOfOneArea)
                        maxSizeOfOneArea = area;
                    numberOfArea++;
                }
            }
        }
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;

        return answer;
    }
    public static int BFS(int[][] picture,boolean[][] visit, int x,int y,int m,int n) {
        Queue<Point> queue = new LinkedList<>();
        int[] dx = {-1,0,1,0};
        int[] dy = {0,1,0,-1};
        int val = picture[x][y],nx=0,ny=0,count=0;

        queue.add(new Point(x,y));
        visit[x][y] = true;

        while(!queue.isEmpty()){
            Point temp = queue.poll();
            count++;
            for(int i=0;i<4;i++){
                nx = temp.x + dx[i];
                ny = temp.y + dy[i];

                if(nx>=0 && nx<m && ny>=0 && ny<n && !visit[nx][ny] && val == picture[nx][ny]){
                    queue.add(new Point(nx,ny));
                    visit[nx][ny] = true;
                }
            }
        }
        return count;
    }
}
class Point{
    int x=0;
    int y=0;

    public Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}

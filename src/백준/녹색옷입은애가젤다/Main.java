package 백준.녹색옷입은애가젤다;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.Arrays;
    import java.util.PriorityQueue;
    import java.util.StringTokenizer;

    public class Main {
        public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        public static int[] dx={-1,0,1,0},dy={0,1,0,-1};
        public static int count=1;
        public static class Node implements Comparable<Node>{
            int x;
            int y;
            int Brupee;

            public Node(int x,int y, int Brupee){
                this.x = x;
                this.y = y;
                this.Brupee = Brupee;
            }
            @Override
            public int compareTo(Node o) {
                return this.Brupee - o.Brupee;
            }
        }
        public static void main(String[] args) throws IOException {
            int n=0,count=1,ans=0;
            StringBuilder sb = new StringBuilder();
            while(true){
                n = Integer.parseInt(br.readLine());
                if(n == 0)
                    break;
                else
                    sb.append("Problem ").append(count++).append(": ").append(solve(n)).append("\n");;
            }
            System.out.print(sb.toString());
        }
        public static int solve(int n) throws IOException {
            int i=0,j=0,x=0,y=0,nx=0,ny=0,Brupee=0;
            int[][] map = new int[n][n], distanceMap= new int[n][n];
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Node> pq = new PriorityQueue<>();

            init(n,map,distanceMap);
            pq.add(new Node(0,0,map[0][0]));
            distanceMap[0][0] = map[0][0];
            while(!pq.isEmpty()) {
                Node now = pq.poll();

                x = now.x;
                y = now.y;
                Brupee = now.Brupee;

                for(i=0;i<4;i++) {
                    nx = x + dx[i];
                    ny = y + dy[i];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n && distanceMap[nx][ny] > Brupee + map[nx][ny]) {
                        distanceMap[nx][ny] = Brupee + map[nx][ny];
                        pq.add(new Node(nx, ny, distanceMap[nx][ny]));
                    }
                }
            }
            return distanceMap[n-1][n-1];
        }
        public static void init(int n,int[][] map, int[][] distanceMap) throws IOException {
            int i=0,j=0;

            for(i=0;i<n;i++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                Arrays.fill(distanceMap[i],Integer.MAX_VALUE);
                for(j=0;j<n;j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
    }
package 백준.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, K = 0, L = 0;
    public static int[][] map;
    public static Deque<Point> snake = new LinkedList<>();
    public static Queue<Command> commands = new LinkedList<>();
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {1, 0, -1, 0};


    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static class Command {
        int time;
        char direction;

        public Command(int time, char direction) {
            this.time = time;
            this.direction = direction;
        }
    }

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        map = new int[N + 1][N + 1];

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = 1;
        }

        L = Integer.parseInt(br.readLine());

        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            commands.add(new Command(Integer.parseInt(st.nextToken()), st.nextToken().charAt(0)));
        }
        System.out.println(playGame());
    }

    public static int playGame() {
        int turn = 0, apples = 0, dir = 0;
        int headX = 0, headY = 0, nextX = 0, nextY = 0;
        boolean[][] visit = new boolean[N + 1][N + 1];
        snake.add(new Point(1, 1));
        visit[1][1] = true;
        while (true) {
            turn++;
            Point head = snake.getLast();

            headX = head.x;
            headY = head.y;

            nextX = headX + dx[dir];
            nextY = headY + dy[dir];

            if (nextX < 1 || nextY < 1 || nextX > N || nextY > N || visit[nextX][nextY])
                break;

            snake.addLast(new Point(nextX, nextY));
            visit[nextX][nextY] = true;

            if (map[nextX][nextY] == 1) {
                map[nextX][nextY] = 0;
                apples++;
            } else {
                Point tail = snake.removeFirst();
                visit[tail.x][tail.y] = false;
            }

            if (!commands.isEmpty() && turn == commands.peek().time) {
                Command command = commands.poll();
                if (command.direction == 'L')
                    dir = (dir + 3) % 4;
                else
                    dir = (dir + 5) % 4;
            }
        }
        return turn;
    }
}

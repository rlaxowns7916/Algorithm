package 백준.뱀;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static int[][] map;
    public static int n, k, l;
    public static Queue<Command> commands = new LinkedList<>();
    public static Deque<Point> snake = new LinkedList<>();


    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        input();
        int turn = 0;
        int currentDir = 1;
        int nextX = 0, nextY = 0;
        snake.add(new Point(1, 1));

        while (true) {
            turn++;
            Point head = snake.getFirst();

            nextX = head.x + dx[currentDir];
            nextY = head.y + dy[currentDir];
            Point nextHead = new Point(nextX, nextY);

            if (nextHead.x > 0 && nextHead.x <= n && nextHead.y > 0 && nextHead.y <= n && !snake.contains(nextHead)) {
                if (map[nextHead.x][nextHead.y] == 1) {
                    map[nextHead.x][nextHead.y] = 0;
                } else {
                    snake.removeLast();
                }
                snake.addFirst(nextHead);
            } else {
                break;
            }

            if (!commands.isEmpty() && commands.peek().second == turn) {
                Command command = commands.poll();
                currentDir = getNextDir(currentDir, command.direction);
            }
        }

        System.out.println(turn);
    }

    public static int getNextDir(int currentDir, char dirCommand) {
        /**
         * 오른쪽
         */
        if (dirCommand == 'D') {
            return (currentDir + 1) % 4;
        }
        /**
         * 왼쪽
         */
        else {
            return (currentDir + 3) % 4;
        }
    }

    public static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n + 1][n + 1];

        k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            map[x][y] = 1;
        }

        l = Integer.parseInt(br.readLine());
        for (int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int second = Integer.parseInt(st.nextToken());
            char direction = st.nextToken().charAt(0);

            Command command = new Command(second, direction);
            commands.add(command);
        }

    }

    static class Command {
        int second;
        char direction;

        public Command(int second, char direction) {
            this.second = second;
            this.direction = direction;
        }
    }

    static class Point {
        int x = 0;
        int y = 0;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }
}

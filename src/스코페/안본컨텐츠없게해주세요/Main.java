package 스코페.안본컨텐츠없게해주세요;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, M = 0;
    public static Map<Character, Double> prefer = new LinkedHashMap<>();

    public static class Info implements Comparable<Info> {
        int priority;
        char genre;
        int x;
        int y;

        public Info(int priority, int x, int y) {
            this.priority = priority;
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Info o) {
            if (this.priority == o.priority) {
                if (o.genre == this.genre) {
                    if (this.x == o.x)
                        return this.y - o.y;
                    else
                        return this.x - o.x;
                } else {
                    double n1 = prefer.get(this.genre);
                    double n2 = prefer.get(o.genre);

                    if (n1 < n2)
                        return 1;
                    else if (n1 == n2)
                        return 0;
                    else
                        return -1;
                }
            } else
                return this.priority - o.priority;
        }

        @Override
        public String toString() {
            return genre + " " + prefer.get(genre) + " " + x + " " + y;
        }
    }

    public static ArrayList<Info> info = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        int i = 0, j = 0, priority, next = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (i = 0; i < 5; i++)
            prefer.put((char) (i + 65), Double.parseDouble(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (i = 0; i < N; i++) {
            String input = br.readLine();
            for (j = 0; j < M; j++) {
                char tmp = input.charAt(j);
                if (tmp == 'Y')
                    priority = 1;
                else if (tmp == 'O')
                    priority = 2;
                else
                    priority = 3;
                info.add(new Info(priority, i, j));
            }
        }
        for (i = 0; i < N; i++) {
            String input = br.readLine();
            for (j = 0; j < M; j++)
                info.get(next++).genre = input.charAt(j);
        }

        info.stream().filter(it -> it.priority != 3).sorted().forEach(System.out::println);
    }
}

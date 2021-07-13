package 백준.강의실;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int id = 0, start = 0, end = 0, cnt = 1;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ArrayList<Lecture> startASC = new ArrayList<>();
        PriorityQueue<Lecture> endASC = new PriorityQueue(Comparator.comparingInt(o -> ((Lecture) o).end));

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            id = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());

            startASC.add(new Lecture(id, start, end));
        }
        Collections.sort(startASC, Comparator.comparingInt(o -> o.start));
        endASC.add(startASC.get(0));
        for (int i = 1; i < startASC.size(); i++) {
            if (startASC.get(i).start >= endASC.peek().end)
                endASC.poll();
            else
                cnt++;
            endASC.add(startASC.get(i));
        }
        System.out.println(cnt);
    }
}

class Lecture {
    int id;
    int start;
    int end;

    public Lecture(int id, int start, int end) {
        this.id = id;
        this.start = start;
        this.end = end;
    }
}

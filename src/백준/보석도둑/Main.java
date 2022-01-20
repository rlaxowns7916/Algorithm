package 백준.보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0, K = 0;
    public static Jewelry[] jewelries;
    public static int[] bags;

    static class Jewelry implements Comparable<Jewelry> {
        int value;
        int size;

        public Jewelry(int value, int size) {
            this.value = value;
            this.size = size;
        }

        @Override
        public int compareTo(Jewelry o) {
            return this.size - o.size;
        }
    }

    public static void main(String[] args) throws IOException {
        int value = 0, size = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        jewelries = new Jewelry[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            size = Integer.parseInt(st.nextToken());
            value = Integer.parseInt(st.nextToken());

            jewelries[i] = new Jewelry(value, size);
        }
        for (int i = 0; i < K; i++) {
            size = Integer.parseInt(br.readLine());
            bags[i] = size;
        }
        Arrays.sort(jewelries);
        Arrays.sort(bags);
        System.out.println(solve());
    }

    public static long solve() {
        long sum = 0L;
        int bagIndex = 0, jewelryIndex = 0;
        PriorityQueue<Jewelry> pq = new PriorityQueue<>((o1, o2) -> o2.value - o1.value);

        for (bagIndex = 0; bagIndex < K; bagIndex++) {
            while (jewelryIndex < N) {
                if (bags[bagIndex] >= jewelries[jewelryIndex].size)
                    pq.add(jewelries[jewelryIndex++]);
                else
                    break;

            }
            if (!pq.isEmpty())
                sum += pq.poll().value;
        }
        return sum;
    }
}
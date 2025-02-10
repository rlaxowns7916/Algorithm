package 백준.보석도둑;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long answer = 0;
        int index =0 ,N = Integer.parseInt(st.nextToken()), K = Integer.parseInt(st.nextToken());
        int[] bags = new int[K];
        Jewel[] jewels = new Jewel[N];
        PriorityQueue<Jewel> pq = new PriorityQueue<>(Comparator.comparing(it -> it.value * -1));

        for(int i=0; i<N;i++){
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for(int i=0; i<K; i++){
            bags[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(bags);
        Arrays.sort(jewels, Comparator.comparing(it -> it.weight));


        for (int bag : bags) {
            while (index < N) {
                if (jewels[index].weight <= bag) {
                    pq.add(jewels[index++]);
                } else {
                    break;
                }
            }

            if (!pq.isEmpty()) {
                answer += pq.poll().value;
            }
        }

        System.out.print(answer);
    }

    static class Jewel{

        int weight;
        int value;

        public Jewel(int weight, int value){
            this.weight = weight;
            this.value = value;
        }
    }
}

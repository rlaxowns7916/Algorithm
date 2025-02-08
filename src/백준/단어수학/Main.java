package 백준.단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()),num = 9,answer = 0;
        String[] words = new String[N];
        HashMap<Character,Integer> map = new HashMap<>();


        for(int i=0; i<N; i++){
            words[i] = br.readLine();
        }

        for (String word : words) {
            int pow = 1;
            for (int i = word.length() - 1; i >= 0; i--) {
                char key = word.charAt(i);
                map.put(key, map.getOrDefault(key, 0) + pow);
                pow *= 10;
            }
        }

        List<Integer> sorted = map.values().stream().sorted((o1,o2) -> o2 - o1).collect(Collectors.toList());

        for(int value: sorted){
            answer += value * num--;
        }

        System.out.print(answer);

    }
}
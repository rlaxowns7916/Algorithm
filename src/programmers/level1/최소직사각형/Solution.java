package programmers.level1.최소직사각형;

import java.util.ArrayList;

public class Solution {
    public int solution(int[][] sizes) {
        ArrayList<Integer> w = new ArrayList<>();
        ArrayList<Integer> h = new ArrayList<>();

        for(int [] size : sizes){
            w.add(Math.max(size[0],size[1]));
            h.add(Math.min(size[0],size[1]));
        }

        int wMax = w.stream().max(Integer::compareTo).orElseThrow();
        int hMax = h.stream().max(Integer::compareTo).orElseThrow();


        return wMax * hMax;
    }

}

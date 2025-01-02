package programmers.level1.푸드파이트대회;

import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public String solution(int[] food) {
        StringBuilder sb = new StringBuilder();
        Deque<String> deque = new LinkedList<>();

        deque.add("0");

        for(int i = food.length - 1; i>= 1; i--){
            int foodCount = food[i];
            int allocatableFoodCount = foodCount / 2;

            for(int j =0; j<allocatableFoodCount;j++){
                deque.addFirst(String.valueOf(i));
                deque.addLast(String.valueOf(i));
            }
        }


        while(!deque.isEmpty()){
            sb.append(deque.poll());
        }

        return sb.toString();
    }
}

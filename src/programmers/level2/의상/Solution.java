package programmers.level2.의상;

import java.util.LinkedHashMap;

public class Solution {
    public int solution(String[][] clothes) {
        int answer = 1;
        LinkedHashMap<String,Integer> counter = new LinkedHashMap<>();

        for(String[] cloth: clothes){
            String name = cloth[0];
            String category = cloth[1];

            int count = counter.getOrDefault(category,1);
            counter.put(category,count + 1);
        }

        for(String category : counter.keySet()){
            answer *= counter.get(category);
        }

        return answer - 1;
    }
}

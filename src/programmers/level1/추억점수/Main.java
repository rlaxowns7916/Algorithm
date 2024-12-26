package programmers.level1.추억점수;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public Integer[] solution(String[] name, int[] yearning, String[][] photo) {
        Map<String,Integer> nameYearningHolder = new HashMap<>();
        for(int i=0; i<name.length; i++){
            nameYearningHolder.put(name[i],yearning[i]);
        }

        return Arrays.stream(photo)
                .map(it ->
                    Arrays.stream(it)
                        .map(nameYearningHolder::get)
                        .filter(score -> score != null)
                        .reduce(0, Integer::sum)
                ).collect(Collectors.toList()).toArray(new Integer[0]);
    }

}

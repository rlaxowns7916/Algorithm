package programmers.level2.전화번호목록;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    public boolean solution(String[] phone_book) {
        List<String> sorted =
                Arrays.stream(phone_book).sorted(new Comparator<String>() {
                    @Override
                    public int compare(String o1, String o2) {
                        return o1.compareTo(o2);
                    }
                }).collect(Collectors.toList());

        for(int i=0;i < sorted.size() - 1; i++){
            if(sorted.get(i+1).startsWith(sorted.get(i))){
                return false;
            }
        }

        return true;
    }
}


package programmers.level1.개인정보수집유효기간;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public Integer[] solution(String today, String[] terms, String[] privacies) {
        int i =1;
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> termHolder = new HashMap<>();

        for(String term: terms){
            String[] token = term.split(" ");
            termHolder.put(token[0],Integer.parseInt(token[1]));
        }

        for(String privacy : privacies){
            String[] token = privacy.split(" ");
            String expireDate = calculateExpireDate(token[0],termHolder.get(token[1]));

            if(toNumber(today) > toNumber(expireDate)){
                result.add(i);
            }
            i++;
        }


        return result.toArray(new Integer[0]);
    }

    private int toNumber(String date){
        int result = 0;
        String[] token = date.split("\\.");

        result += Integer.parseInt(token[2]);
        result += Integer.parseInt(token[1]) * 28;
        result += Integer.parseInt(token[0]) * 12 * 28;

        return result;
    }

    private String calculateExpireDate(
            String startDate,
            int persistMonthRange
    ){
        String[] tokens = startDate.split("\\.");

        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]) + persistMonthRange;
        int day =  Integer.parseInt(tokens[2]) - 1;


        if(day <= 0){
            day = 28 - day;
            month++;
        }

        if(month > 12){
            month  = (month % 12)+1;
            year += month / 2;
        }

        return String.format("%02d.%02d.%02d",year,month,day);
    }
}

package programmers.level1.데이터분석;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        List<Data> dataList = Arrays.stream(data).map(it -> new Data(it[0],it[1],it[2],it[3])).toList();
        List<Data> filtered = dataList.stream().filter(it ->{
            return switch (ext) {
                case "code" -> it.code < val_ext;
                case "date" -> it.date < val_ext;
                case "maximum" -> it.maximum < val_ext;
                case "remain" -> it.remain < val_ext;
                default -> throw new IllegalArgumentException("Not Supported");
            };
        }).sorted((o1, o2) -> {
            return switch (sort_by){
                case "code" -> Integer.compare(o1.code,o2.code);
                case "date" -> Integer.compare(o1.date,o2.date);
                case "maximum" -> Integer.compare(o1.maximum,o2.maximum);
                case "remain" -> Integer.compare(o1.remain,o2.remain);
                default -> throw new IllegalArgumentException("Not Supported");
            };
        }).collect(Collectors.toList());


        int[][] answer = new int [filtered.size()][4];

        for(int i=0;i<filtered.size();i++){
            answer[i][0] = filtered.get(i).code;
            answer[i][1] = filtered.get(i).date;
            answer[i][2] = filtered.get(i).maximum;
            answer[i][3] = filtered.get(i).remain;
        }
        return answer;
    }

    private

    static class Data{
        private final int code;
        private final int date;
        private final int maximum;
        private final int remain;

        public Data(
            int code,
            int date,
            int maximum,
            int remain
        ){
            this.code = code;
            this.date = date;
            this.maximum = maximum;
            this.remain = remain;
        }
    }
}

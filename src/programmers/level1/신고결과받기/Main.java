package programmers.level1.신고결과받기;

import java.util.*;
import java.util.function.IntFunction;
import java.util.stream.Collectors;

public class Main {
    public Integer[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportHistory = new HashMap<>();
        Map<String,Set<String>> reportedHistory = new HashMap<>();

        for(String id : id_list){
            reportHistory.put(id,new HashSet<>());
            reportedHistory.put(id, new HashSet<>());
        }

        for(String detail: report){
            String[] tokens = detail.split(" ");

            reportHistory.get(tokens[0]).add(tokens[1]);
            reportedHistory.get(tokens[1]).add(tokens[0]);
        }

        List<String> banned = reportedHistory.entrySet().stream().filter(it -> it.getValue().size() >= k).map( it-> it.getKey()).collect(Collectors.toList());

        return Arrays.stream(id_list).map(id ->{
                Set<String> idReportHistory = reportHistory.get(id);
                return (int)(banned.stream().filter(idReportHistory::contains).count());
        }).toArray(Integer[]::new);
    }
}

package programmers.level1.달리기경주;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public String[] solution(String[] players, String[] callings) {
        String[] answer = new String[players.length];
        Map<String,Integer> rankByPlayer = new LinkedHashMap<>();
        Map<Integer,String> playerByRank = new LinkedHashMap<>();


        for(int i=0; i< players.length; i++){
            rankByPlayer.put(players[i],i);
            playerByRank.put(i,players[i]);
        }

        for(String calling: callings){
            swap(calling, rankByPlayer, playerByRank);
        }

        for(int i=0; i < players.length; i++){
            answer[i] = playerByRank.get(i);
        }

        return answer;
    }

    private void swap(
        String caller,
        Map<String,Integer> rankByPlayer,
        Map<Integer,String> playerByRank
    ){
        int callerRank = rankByPlayer.get(caller);
        String swappedPlayer = playerByRank.get(callerRank - 1);

        rankByPlayer.put(caller, callerRank - 1);
        rankByPlayer.put(swappedPlayer, callerRank);

        playerByRank.put(callerRank-1, caller);
        playerByRank.put(callerRank, swappedPlayer);
    }
}

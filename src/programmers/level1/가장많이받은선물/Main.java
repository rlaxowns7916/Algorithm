package programmers.level1.가장많이받은선물;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Main {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int[] expectedGifts = new int[friends.length];
        int[] giftScores = new int[friends.length];
        int[][] giftMap = new int[friends.length][friends.length];
        Map<String,Integer> friendsIndexHolder = new LinkedHashMap<>();

        for(int i=0;i<friends.length;i++){
            friendsIndexHolder.put(friends[i],i);
        }

        for(String gift: gifts){
            String[] token = gift.split(" ");

            int fromIndex = friendsIndexHolder.get(token[0]);
            int toIndex = friendsIndexHolder.get(token[1]);

            giftMap[fromIndex][toIndex]++;
        }

        for(String friend: friends){
            int friendIndex = friendsIndexHolder.get(friend);

            int sendCount = Arrays.stream(giftMap[friendIndex]).sum();
            int receiveCount = Arrays.stream(giftMap).map(it -> it[friendIndex]).reduce(0, Integer::sum);

            giftScores[friendIndex] = sendCount - receiveCount;
        }

        for(String friend: friends){
            int friendIndex = friendsIndexHolder.get(friend);

            for(int i=0;i<friends.length;i++){
                if(friendIndex == i){continue;}

                if(giftMap[friendIndex][i] > giftMap[i][friendIndex]){
                    expectedGifts[friendIndex]++;
                }else if(
                    giftMap[friendIndex][i] == giftMap[i][friendIndex]
                    && giftScores[friendIndex] > giftScores[i]
                ){
                    expectedGifts[friendIndex]++;
                }
            }
            answer = Math.max(answer,expectedGifts[friendIndex]);
        }

        return answer;
    }
}

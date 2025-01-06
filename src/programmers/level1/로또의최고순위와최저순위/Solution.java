package programmers.level1.로또의최고순위와최저순위;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;


class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int unknownNum = 0, correctNum = 0;
        Set<Integer> winNumSet = Arrays.stream(win_nums).boxed().collect(Collectors.toSet());


        for (int lottoNum : lottos) {
            if (lottoNum == 0) {
                unknownNum++;
            } else if (winNumSet.contains(lottoNum)) {
                correctNum++;
            }
        }

        return new int[]{Math.min(7 - (unknownNum + correctNum),6) ,Math.min(7-correctNum,6)};
    }
}
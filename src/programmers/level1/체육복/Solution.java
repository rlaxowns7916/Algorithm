package programmers.level1.체육복;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Set<Integer> lostSet = new HashSet<>();
        Set<Integer> reserveSet = new HashSet<>();

        for (int l : lost) lostSet.add(l);
        for (int r : reserve) {
            if (lostSet.contains(r)) lostSet.remove(r); // 중복 제거
            else reserveSet.add(r);
        }

        List<Integer> sortedLost = lostSet.stream().sorted().collect(Collectors.toList());

        int answer = n - sortedLost.size();
        for (int lostOne : sortedLost) {
            if (reserveSet.remove(lostOne - 1) || reserveSet.remove(lostOne + 1)) {
                answer++;
            }
        }

        return answer;
    }
}
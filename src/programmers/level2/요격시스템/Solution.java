package programmers.level2.요격시스템;

import java.util.Arrays;

class Solution {
    public int solution(int[][] targets) {
        int answer = 0,before = 0;
        Arrays.sort(targets,(arr1,arr2) -> arr1[1] - arr2[1]);

        for(int[] target: targets){
            if(before <= target[0]){
                before = target[1];
                answer++;
            }
        }


        return answer;
    }
}

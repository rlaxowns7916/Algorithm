package programmers.level2.구명보트;

import java.util.Arrays;
import java.util.Stack;

public class Solution {
    /**
     * 최대 50000명이 있기 떄문에, 완전탐색을 하면 25억이 넘어가서, 시간초과가 발생
     * 그렇기에 Greedy로 접근한다.
     * 한 구명보트에는 2명밖에 타지 못한다.
     * 최대한 꽉 채울 수 있는 2명을 태운다.
     * List가 빌 떄 까지 Loop를 돌면서, 무게 범위내에서 무거운 사람들을 우선 꽉 채울 것이다.
     * 중간에 스킵되는 경우도 있으니, 완전탐색보단 빠를 것이다.
     *
     * 아무래도 visit배열을 사용한다해도, 결국 순회의 양은 줄지 않으니 시간이 많이소비된다.
     * 다른 Collection이 필요하다.
     *
     * Stack을 2개사용해서, 임시로 pop했던걸 다시 복구해주자
     *
     * heaviest와 lightest의 조합만으로도 최적의 해를 구할 수 있었다.
     */

    public int solution(int[] people, int limit) {
        int boat=0,left=0,right=people.length-1;

        Arrays.sort(people);

        while(left <= right){
            int heaviest = people[right--];

            if(heaviest + people[left] <= limit){
                left++;
            }
            boat++;
        }
        return boat;
    }
}

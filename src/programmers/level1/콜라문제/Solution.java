package programmers.level1.콜라문제;

public class Solution {
    public int solution(int a, int b, int n) {
        int newBottle = 0;
        int remainBottle = n;

        while(remainBottle > a){
            newBottle += b * (remainBottle / a);
            remainBottle = remainBottle / a + remainBottle % a;
        }
        return newBottle;
    }
}

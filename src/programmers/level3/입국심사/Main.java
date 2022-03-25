package programmers.level3.입국심사;

public class Main {
    class Solution {
        public long solution(int n, int[] times) {
            long count=0;
            long answer = 0;
            long left=0,right=10000000000000L,mid=0;

            while(left <= right){
                count=0;
                mid = (left+right)/2;
                for(int time : times)
                    count += mid/time;
                if(count < n)
                    left = mid+1;
                else
                    right = mid-1;
            }
            return left;
        }
    }
}

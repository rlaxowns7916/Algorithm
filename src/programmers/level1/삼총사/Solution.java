package programmers.level1.삼총사;

class Solution {
    int answer = 0;
    public int solution(int[] number) {
        calc(0,0,0,number);

        return answer;
    }

    private void calc(int phase, int index, int sum, int[] number){
        if(phase == 3){
            if(sum == 0) answer++;
        }else{
            for(int i=index;i<number.length;i++){
                calc(phase+1,i+1,sum + number[i],number);
            }
        }
    }
}
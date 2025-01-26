package programmers.level2.카펫;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int row=0,col=0;
        int total = brown + yellow;

        for(int i= 2; i * i <= total; i++){
            row = total / i;
            col = i;

            if(isYellowInBrowns(row,col, brown, yellow)){
                break;
            }
        }

        return new int[]{row,col};
    }

    private boolean isYellowInBrowns(int row, int col, int brown, int yellow){
        return (row - 2) * (col - 2) == yellow;
    }
}

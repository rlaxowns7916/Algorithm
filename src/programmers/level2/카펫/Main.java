package programmers.level2.카펫;

class Solution {
    public int[] solution(int brown, int yellow) {
        int row = 0, col = 0, total = brown + yellow;
        boolean isSolve = false;
        int[] answer = new int[2];

        for (int i = 1; i <= total / 2 && !isSolve; i++) {
            if (total % i == 0) {
                row = i;
                col = total / i;
                isSolve = solve(row, col, brown, yellow);
            }
        }
        answer[0] = col;
        answer[1] = row;

        return answer;
    }

    public boolean solve(int row, int col, int brown, int yellow) {
        return (row - 2) * (col - 2) == yellow;
    }
}
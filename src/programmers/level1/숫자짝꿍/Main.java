package programmers.level1.숫자짝꿍;

public class Main {

    public static void main(String[] args) {
        System.out.println(solution("9111","91111"));
    }

    public static String solution(String X, String Y) {
        int[] xCount = new int[10];
        int[] yCount = new int[10];
        StringBuilder answer = new StringBuilder();

        for(int i=0; i<X.length();i++){
            char value = X.charAt(i);
            xCount[value-'0']++;
        }

        for(int i=0; i<Y.length();i++){
            char value = Y.charAt(i);
            yCount[value-'0']++;
        }

        for(int i=9;i>=0;i--){
            if(xCount[i] > 0 && yCount[i] > 0){
                answer.append(String.valueOf(i).repeat(Math.min(xCount[i], yCount[i])));
            }
        }


        return answer.length() == 0 ? "-1" : (answer.toString().charAt(0) == '0' ? "0" : answer.toString());
    }
}

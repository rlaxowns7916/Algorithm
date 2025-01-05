package programmers.level1.숫자문자열과영단어;

public class Solution {
    public int solution(String s) {
        StringBuilder alphabet = new StringBuilder();
        StringBuilder answer = new StringBuilder();
        for(int i=0;i<s.length();i++){
            char current = s.charAt(i);
            if('0'<= current && current <= '9'){
                if(alphabet.length() != 0){
                    answer.append(parseToNumberFormat(alphabet.toString()));
                    alphabet.setLength(0);
                }
                answer.append(current);
            }else{
                alphabet.append(current);
            }
        }
        if(alphabet.length() != 0){
            answer.append(parseToNumberFormat(alphabet.toString()));
        }


        return Integer.parseInt(answer.toString());
    }

    public String parseToNumberFormat(String s){
        String input = s;
        StringBuilder answer = new StringBuilder();

        while(input.length() > 0){
            if(input.startsWith("zero")){
                answer.append(0);
                input = input.replaceFirst("zero","");
            } else if (input.startsWith("one")) {
                answer.append(1);
                input = input.replaceFirst("one","");
            }else if (input.startsWith("two")) {
                answer.append(2);
                input = input.replaceFirst("two","");
            }
            else if (input.startsWith("three")) {
                answer.append(3);
                input = input.replaceFirst("three","");
            }
            else if (input.startsWith("four")) {
                answer.append(4);
                input = input.replaceFirst("four","");
            }
            else if (input.startsWith("five")) {
                answer.append(5);
                input = input.replaceFirst("five","");
            }
            else if (input.startsWith("six")) {
                answer.append(6);
                input = input.replaceFirst("six","");
            }
            else if (input.startsWith("seven")) {
                answer.append(7);
                input = input.replaceFirst("seven","");
            }
            else if (input.startsWith("eight")) {
                answer.append(8);
                input = input.replaceFirst("eight","");
            }
            else if (input.startsWith("nine")) {
                answer.append(9);
                input = input.replaceFirst("nine","");
            }
        }

        return answer.toString();
    }
}

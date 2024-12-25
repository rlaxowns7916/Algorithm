package programmers.level1.성격유형검사하기;

import java.util.*;

public class Main {
    public String solution(String[] survey, int[] choices) {
        String answer = "";
        Map<String,Integer> scoreBoard = new HashMap<>();
        scoreBoard.put("R",0);
        scoreBoard.put("T",0);
        scoreBoard.put("C",0);
        scoreBoard.put("F",0);
        scoreBoard.put("J",0);
        scoreBoard.put("M",0);
        scoreBoard.put("A",0);
        scoreBoard.put("N",0);

        for(int i=0; i< survey.length;i++){
            String currentSurvey = survey[i];
            int currentChoice = choices[i];

            String firstPersonality = String.valueOf(currentSurvey.charAt(0));
            String secondPersonality = String.valueOf(currentSurvey.charAt(1));

            if(currentChoice - 4 == 0){
                continue;
            }else if(currentChoice - 4 > 0){
                scoreBoard.put(secondPersonality,scoreBoard.get(secondPersonality) + (currentChoice - 4));
            }else{
                scoreBoard.put(firstPersonality,scoreBoard.get(firstPersonality) - (currentChoice - 4));
            }
        }

        answer += scoreBoard.get("R") >= scoreBoard.get("T") ? "R" : "T";
        answer += scoreBoard.get("C") >= scoreBoard.get("F") ? "C": "F";
        answer += scoreBoard.get("J") >= scoreBoard.get("M") ? "J": "M";
        answer += scoreBoard.get("A") >= scoreBoard.get("N")? "A": "N";

        return answer;
    }
}
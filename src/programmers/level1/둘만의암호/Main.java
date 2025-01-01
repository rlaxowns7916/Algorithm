package programmers.level1.둘만의암호;

public class Main {
    public String solution(String s, String skip, int index) {
        char[] characters = s.toCharArray();

        for(int i=0; i< characters.length;i++){
            int loop = 1;
            int before = characters[i];
            int after = before;

            while(loop <= index){
                after += 1;
                if(after > 'z'){after = 'a';}
                if(skip.contains(String.valueOf((char)after))){continue;}
                loop++;
            }

            characters[i] = (char) after;
        }
        return new String(characters);
    }
}

package programmers.level2.모음사전;

import java.util.Collections;
import java.util.LinkedList;

public class Main {
    class CompleteSearch {
        public int solution(String word) {
            int count = 0;
            LinkedList<String> list = new LinkedList<>();
            makeString(list, "", 0);

            Collections.sort(list);

            for (int i = 0; i < list.size(); i++) {
                if (word.equals(list.get(i))) {
                    count = i + 1;
                    break;
                }
            }
            return count;
        }

        public void makeString(LinkedList<String> list, String origin, int depth) {
            String alphabets = "AEIOU";
            if (depth < 5) {
                for (int i = 0; i < alphabets.length(); i++) {
                    char alphabet = alphabets.charAt(i);
                    String newString = origin + alphabet;
                    list.add(newString);
                    makeString(list, newString, depth + 1);
                }
            }
        }
    }

    class DFS {
        boolean find = false;
        int count = 0;
        public String input = "AEIOU";

        public int solution(String word) {
            search("", word, 0);
            return count;
        }

        public void search(String now, String target, int depth) {
            if(depth >= 5 || find){
                return;
            }else{
                for(int i=0;i<input.length() && !find;i++){
                    count++;
                    char ch = input.charAt(i);
                    String newString = now + ch;

                    if(newString.equals(target)){
                        find = true;
                    }else{
                        search(newString,target,depth+1);
                    }
                }
            }
        }
    }
}

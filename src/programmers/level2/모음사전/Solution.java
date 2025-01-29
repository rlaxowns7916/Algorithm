package programmers.level2.모음사전;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public int solution(String word) {
        char[] vowels = {'A', 'E', 'I', 'O', 'U'};
        Queue<String> queue = new LinkedList<>();
        int count = 0;

        queue.add("");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            if (current.equals(word)) {
                break;
            }
            count++;
            if (current.length() < 5) {
                for (char vowel : vowels) {
                    queue.add(current + vowel);
                }
            }
        }
        return count;
    }
}

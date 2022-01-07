package programmers.level3.불량사용자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static int answer = 0;
    public static Set<String> result = new HashSet<>();

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    }

    public int solution(String[] user_id, String[] banned_id) {
        boolean[] visit = new boolean[user_id.length];
        calc(0, user_id, banned_id, visit);
        return answer;
    }

    public static void calc(int depth, String[] user_id, String[] banned_id, boolean[] visit) {
        if (depth > banned_id.length)
            return;
        else if (depth == banned_id.length) {
            StringBuilder resultString = new StringBuilder();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i])
                    resultString.append(i);
            }
            result.add(resultString.toString());
        } else {
            ArrayList<Integer> markIndex = findMarked(banned_id[depth]);
            for (int j = 0; j < user_id.length; j++) {
                if (!visit[j] && banned_id[depth].length() == user_id[j].length()) {
                    String markedString = mark(markIndex, user_id[j]);
                    if (banned_id[depth].equals(markedString)) {
                        visit[j] = true;
                        calc(depth + 1, user_id, banned_id, visit);
                        visit[j] = false;
                    }
                }
            }
        }
    }

    public static String mark(ArrayList<Integer> markIndex, String origin) {
        StringBuilder sb = new StringBuilder(origin);
        for (Integer index : markIndex)
            sb.setCharAt(index, '*');
        return sb.toString();
    }

    public static ArrayList<Integer> findMarked(String str) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '*')
                list.add(i);
        }
        return list;
    }
}

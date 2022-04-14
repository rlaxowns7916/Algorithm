package 백준.가르침;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main2 {
    public static int N = 0, K = 0, max = 0;
    public static String[] vocas;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Character> uniqueAlphabet = new HashSet<>();

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        vocas = new String[N];

        for (int i = 0; i < N; i++) {
            vocas[i] = br.readLine();
            for (int j = 0; j < vocas[i].length(); j++) {
                char ch = vocas[i].charAt(j);
                if (!isEssential(ch))
                    uniqueAlphabet.add(ch);
            }
        }

        List<Character> chosenAlphabet = new ArrayList<>(uniqueAlphabet);
        boolean[] visit = new boolean[chosenAlphabet.size()];

        if (K >= 5)
            comb(chosenAlphabet.size(), 0, K - 5, 0, chosenAlphabet, visit);

        System.out.println(max);
    }

    public static boolean isEssential(char ch) {
        return ch == 'a' || ch == 'n' || ch == 't' || ch == 'i' || ch == 'c';
    }

    public static void comb(int total, int index, int target, int pick, List<Character> chosenAlphabet, boolean[] visit) {
        if (target == pick || pick == total) {
            boolean[] alphabet = new boolean[26];
            for (int i = 0; i < visit.length; i++) {
                if (visit[i])
                    alphabet[chosenAlphabet.get(i) - 'a'] = true;
            }
            max = Math.max(max, canRead(alphabet));
        } else if (total > index) {
            visit[index] = true;
            comb(total, index + 1, target, pick + 1, chosenAlphabet, visit);
            visit[index] = false;
            comb(total, index + 1, target, pick, chosenAlphabet, visit);
        }
    }

    public static int canRead(boolean[] alphabets) {
        int readCount = 0;

        for (String voca : vocas) {
            boolean flag = true;
            for (int i = 0; i < voca.length(); i++) {
                char ch = voca.charAt(i);
                if (!alphabets[ch - 'a'] && !isEssential(ch) ) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                readCount++;
        }
        return readCount;
    }
}

package programmers.level2.튜플;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int[] arr = solution(str);

        for(int token: arr)
            System.out.println(token);

    }

    public static int[] solution(String s) {
        int i = 0, max = 0, index = 0, cnt = 0;
        boolean[] check = new boolean[100001];
        ArrayList<Integer> ret = new ArrayList();
        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("}");
        for (i = 0; i < arr.length; i++)
            arr[i] = arr[i].replace(",{", "");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for (String str : arr) {
            StringTokenizer st = new StringTokenizer(str, ",");
            while (st.hasMoreTokens()) {
                int val = Integer.parseInt(st.nextToken());
                if(!check[val]){
                    ret.add(val);
                    check[val]=true;
                }
            }
        }
        return ret.stream().mapToInt(it -> it).toArray();
    }
}

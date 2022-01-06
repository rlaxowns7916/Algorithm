package programmers.level2.문자열압축;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main2 {
    public static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(solution(br.readLine()));
    }

    public static int solution(String s) {
        int len = s.length(), i = 0, min = len;
        for (i = 1; i <= len / 2; i++) {
            sb = new StringBuilder();
            min = Math.min(min, makeString(parse(i, s)));
        }
        return min;
    }

    public static int makeString(String[] arr) {
        int cnt = 1;
        for (int i = 0; i < arr.length; i++) {
            if (i == arr.length - 1) {
                if (cnt == 1)
                    sb.append(arr[i]);
                else
                    sb.append(cnt).append(arr[i]);
            } else {
                if (arr[i].equals(arr[i + 1]))
                    cnt++;
                else {
                    if (cnt > 1)
                        sb.append(cnt);
                    sb.append(arr[i]);
                    cnt = 1;
                }
            }
        }
        return sb.length();
    }

    public static String[] parse(int tokenLen, String s) {
        int i = 0, cnt = 0, len = s.length(), size = len % tokenLen == 0 ? len / tokenLen : len / tokenLen + 1;
        String[] arr = new String[size];
        while (i < len) {
            if (i + tokenLen <= len)
                arr[cnt++] = s.substring(i, i + tokenLen);
            else
                arr[cnt] = s.substring(i, len);
            i += tokenLen;
        }
        return arr;
    }
}

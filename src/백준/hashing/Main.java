package 백준.hashing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int mod = 1234567891; // M 값
        int r = 31; // r 값

        int length = Integer.parseInt(br.readLine());
        String input = br.readLine();
        System.out.println(hash(input, r, mod));
    }

    public static long hash(String input, int r, int mod) {
        long hash = 0; // 최종 해시 값
        long rPow = 1; // r^i 값을 저장 (초기 r^0 = 1)

        for (int i = 0; i < input.length(); i++) {
            int value = input.charAt(i) - 'a' + 1; // 알파벳 값을 계산
            hash = (hash + (value * (rPow % mod))%mod) % mod; // 누적 해시 값 계산
            rPow = (rPow * r) % mod; // r^i 갱신
        }

        return hash;
    }
}

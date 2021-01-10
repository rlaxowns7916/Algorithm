package programmers.level2.소수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    static int max=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        System.out.println(solution(str));
    }
    public static int solution(String numbers){
        Set<Integer> numberSet = new HashSet();
        char[] chars = numbers.toCharArray();
        int total = chars.length,answer=0,i=0;

        for(i=1;i<=total;i++)
            perm(numberSet,chars,0,total,i);

        return primeNum(numberSet);
    }
    public static int primeNum(Set<Integer> candidate)
    {
        int i=0,ans=0;
        boolean isPrime;

        for(int num: candidate){
            if(num < 2)
                continue;

            isPrime=true;
            for(i=2;i*i<=num;i++){
                if(num%i == 0){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime) ans++;

        }
        return ans;
    }
    public static void perm(Set<Integer> numberSet,char[] chars, int depth, int n, int r){
        if(depth == r) {
            int num = 0;
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < r; i++)
                sb.append(chars[i]);
            num = Integer.parseInt(sb.toString());

            numberSet.add(num);
        }
        else{
            for(int i = depth;i<n;i++){
                swap(chars,i,depth);
                perm(numberSet,chars,depth+1,n,r);
                swap(chars,i,depth);
            }
        }
    }
    public static void swap(char[] chars, int a, int b){
        char tmp = chars[a];
        chars[a] = chars[b];
        chars[b] = tmp;
    }
}

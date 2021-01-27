package 백준.단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class BacktrackingVersion {
    public static Map<Character,Integer> map = new LinkedHashMap<>();
    public static Set<Character> set = new LinkedHashSet<>();
    public static int N = 0,Max=0;
    public static String[] strNums;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        strNums = new String[N];
        int i = 0, j = 0;

        for (i = 0; i < N; i++) {
            strNums[i] = br.readLine();
            for (j = 0; j < strNums[i].length(); j++)
               set.add(strNums[i].charAt(j));
        }
        solve();
        System.out.println(Max);
    }
    public static void solve() {
        int i=0;
        char[] arr = new char [set.size()];
        for(char alphabet : set)
            arr[i++] = alphabet;
        perm(arr,0);
    }
    public static void perm(char[] arr, int depth) {
        if(depth == set.size()){
            int ret = calculate();
            Max = Max>ret?Max:ret;
        }
        else{
            for(int i=depth;i<set.size();i++){
                swap(arr,depth,i);
                map.put(arr[depth],depth);
                perm(arr,depth+1);
                map.remove(arr[depth]);
                swap(arr,depth,i);
            }
        }
    }
    public static int calculate() {
        int maxVal = 9,sum=0;
        for(String strNum : strNums){
            for(int i=0;i< strNum.length();i++)
                sum +=  (maxVal-map.get(strNum.charAt(i)))*Math.pow(10,strNum.length()-(i+1));
        }
        return sum;
    }
    public static void swap(char[] arr, int i,int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
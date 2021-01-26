package 백준.단어수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static int N = 0;
    public static String[] arr;
    public static Map<Character,Integer> store = new HashMap<>();
    public static void main(String[] args) throws IOException {
        int i=0,j=0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new String[N];

        for(i=0;i<N;i++) {
            arr[i] = br.readLine();
            for(j=0;j<arr[i].length();j++){
                char ch = arr[i].charAt(j);

                if(!store.containsKey(ch))
                    store.put(ch,0);
            }
        }
        fillMap();
        System.out.println(calculate());
    }
    public static void fillMap() {
        for(String str : arr){
            for(int i=0;i<str.length();i++){
                char ch = str.charAt(i);
                int value = (int) (store.get(ch).intValue()+Math.pow(10,str.length()-(i+1)));
                store.put(ch,value);
            }
        }
    }
    public static int calculate() {
        List<Map.Entry<Character,Integer>> list = new LinkedList<>(store.entrySet());
        int count=9,sum=0;
        Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
            @Override
            public int compare(Map.Entry<Character, Integer> o1, Map.Entry<Character, Integer> o2) {
                return o2.getValue()-o1.getValue();
            }
        });

        for(int i =0;i<list.size();i++)
            sum += list.get(i).getValue()*count--;

        return sum;
    }
}
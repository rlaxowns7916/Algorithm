package 백준.보물;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Integer> list2 = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        Comparator<Integer> comp1 = (o1, o2) -> o1 - o2;
        Comparator<Integer> comp2 = (o1, o2) -> o2 - o1;


        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list1.add(Integer.parseInt(st.nextToken()));
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            list2.add(Integer.parseInt(st.nextToken()));

        list1.sort(comp1);
        list2.sort(comp2);
        System.out.println(calc());
    }

    public static int calc() {
        int sum = 0;
        for (int i = 0; i < N; i++)
            sum += list1.get(i) * list2.get(i);

        return sum;
    }
}

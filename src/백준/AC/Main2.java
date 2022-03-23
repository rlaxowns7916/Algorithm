package 백준.AC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main2 {
    public static int T = 0;

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            boolean flag = true;
            boolean isOperated = true;
            String input = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String nums = br.readLine();
            ArrayList<Integer> numbers = new ArrayList<>();

            if (N > 0) {
                st = new StringTokenizer(nums.substring(1, nums.length() - 1), ",");
                for (int i = 0; i < N; i++)
                    numbers.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < input.length() && isOperated; i++) {
                if (input.charAt(i) == 'R') {
                    flag = !flag;
                } else {
                    isOperated = remove(flag, numbers);
                }
            }
            if (isOperated)
                sb.append("[").append(print(flag, numbers)).append("]").append("\n");
            else
                sb.append("error").append("\n");
        }
        System.out.println(sb);
    }

    public static String print(boolean flag, ArrayList<Integer> numbers) {
        int size = numbers.size();
        StringBuilder sb = new StringBuilder();

        if (!numbers.isEmpty()) {
            if (flag) {
                for (Integer number : numbers)
                    sb.append(number).append(",");
            } else {
                for (int i = size - 1; i >= 0; i--)
                    sb.append(numbers.get(i)).append(",");
            }
            sb.deleteCharAt(sb.lastIndexOf(","));
        }
        return sb.toString();
    }

    public static boolean remove(boolean flag, ArrayList<Integer> numbers) {
        int size = numbers.size();

        if (size == 0)
            return false;
        else {
            if (flag)
                numbers.remove(0);
            else
                numbers.remove(size - 1);
            return true;
        }
    }
}

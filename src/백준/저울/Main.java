package 백준.저울;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), end = 0;
        int[] scales = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

        for(int scale: scales){
            if(scale > end + 1){
                break;
            }
            end += scale;
        }
        System.out.print(end + 1);
    }
}

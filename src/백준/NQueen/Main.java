package 백준.NQueen;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int N=0,count=0;
    public static int[] record;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        record = new int[N];

        solve(0);

        System.out.println(count);
    }
    public static void solve(int depth)
    {
        int column=0,row=0;
        if(depth == N)
            count++;
        else {
            for(column=0;column<N;column++) {
                boolean flag = true;
                for(row=depth-1;row>=0;row--){
                    if(!possible(row,column,depth)){
                        flag = false;
                        break;
                    }
                }
                if(flag){
                    record[depth] = column;
                    solve(depth + 1);
                }
            }
        }
    }
    public static boolean possible(int row, int col,int depth)
    {
        if(record[row] == col || depth-row == Math.abs(col-record[row]))
            return false;
        return true;
    }
}

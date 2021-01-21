package 백준.색종이만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static int N=0,blue=0,white=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        int[][] Map = new int[N][N];
        int i=0,j=0;

        for(i=0;i<N;i++) {
            st = new StringTokenizer(br.readLine());
            for(j=0;j<N;j++)
                Map[i][j] = Integer.parseInt(st.nextToken());
        }
        solve(Map,0,0,Map.length);
        System.out.println(white);
        System.out.println(blue);
    }

    public static void solve(int[][] Map,int row, int col,int len)
    {
        int i=0,j=0,length = Map.length,val = Map[row][col];
        for(i=row;i<row+len;i++){
            for(j=col;j<col+len;j++){
                if(val != Map[i][j]){
                    solve(Map,row,col,len/2);
                    solve(Map,row+len/2,col,len/2);
                    solve(Map,row,col+len/2,len/2);
                    solve(Map,row+len/2,col+len/2,len/2);
                    return;
                }
            }
        }
        if(val == 0)
            white++;
        else
            blue++;
    }
}
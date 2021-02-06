package 백준.십자뒤집기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static int[][] change = {{0, 1, 3}, {0, 1, 2, 4}, {1, 2, 5}, {0, 3, 4, 6}, {1, 3, 4, 5, 7}, {2, 4, 5, 8}, {3, 6, 7}, {4, 6, 7, 8}, {5, 7, 8}};
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tCase = Integer.parseInt(br.readLine()), i = 0, j = 0, k = 0, ans = 0;
        for (i = 0; i < tCase; i++) {
            for (j = 0; j < 3; j++) {
                String str = br.readLine();
                for (k = 0; k < 3; k++) {
                    if (str.charAt(k) == '*')
                        ans |= 1 << 3 * j + k;
                }
            }
            sb.append(solve(ans)).append("\n");
            ans = 0;
        }
        System.out.println(sb.toString());
    }
    public static int solve(int ans) {
        int i = 0,j=0,nbitmask = 0, count = 0, size = 0;
        boolean flag = false;
        boolean[] visit = new boolean[1<<9];
        Queue<Integer> queue = new LinkedList();
        queue.add(0);
        visit[0]=true;
        while (!queue.isEmpty()) {
            for(i=queue.size();i>0;i--){
               int temp = queue.poll();
               if(temp == ans){
                   flag = true;
                   break;
               }
                for (j = 0; j < 9; j++) {
                    nbitmask = temp;
                    for (int k : change[j])
                        nbitmask ^= 1 << k;
                    if(!visit[nbitmask]){
                        queue.add(nbitmask);
                        visit[nbitmask]=true;
                    }
                }
            }
            if(flag)
                break;
            count++;
        }
        return count;
    }
}
package programmers.level2.숫자변환하기;

import java.util.Arrays;

class Solution {
  public int solution(int x, int y, int n) {
    int[] map = new int[y+1];
    Arrays.fill(map,y+1);
    map[x] = 0;

    for(int i = x;i<y;i++){
      if(i == x || map[i] != y+1){
        if(i + n <= y){
          map[i+n] = Math.min(map[i+n],map[i] + 1);
        }

        if(i * 2 <= y){
          map[i*2] = Math.min(map[i*2],map[i]+ 1);
        }

        if(i*3 <= y){
          map[i*3] = Math.min(map[i*3],map[i]+1);
        }
      }
    }

    return map[y] == y+1 ? -1 : map[y];
  }
}

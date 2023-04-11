package programmers.level2.혼자서하는틱택토;

class Solution {
  public int solution(String[] board) {
    int answer = -1;
    int len = board.length;
    char[][] map = new char[len][len];

    for(int i=0;i<len;i++){
      for(int j=0;j<len;j++){
        map[i][j] = board[i].charAt(j);
      }
    }

    return isPromising(map) ? 1 : 0;
  }
  public boolean isPromising(char[][] map){
    int circle=0,check=0;
    boolean isCircleFinish = false, isCheckFinish = false;
    for(int i=0;i<map.length;i++){
      for(int j=0;j<map.length;j++){
        if(map[i][j] == 'O'){
          circle++;
        }else if(map[i][j] == 'X'){
          check++;
        }
      }
    }
    if(check > circle || circle - check > 1){
      return false;
    }

    isCircleFinish = circle > 2 && isFinish(map,'O');
    isCheckFinish = check > 2 && isFinish(map,'X');

    if(isCircleFinish && circle == check){
      return false;
    }
    if(isCheckFinish && circle > check){
      return false;
    }

    return true;
  }
  public boolean isFinish(char[][]map,char chr){
    return
        (map[0][0] == map[0][1]  && map[0][1] == map[0][2]  && map[0][2]== chr) ||
            (map[1][0] == map[1][1]  && map[1][1] == map[1][2]  && map[1][2]== chr) ||
            (map[2][0] == map[2][1]  && map[2][1] == map[2][2]  && map[2][2]== chr) ||
            (map[0][0] == map[1][1]  && map[1][1] == map[2][2]  && map[2][2]== chr) ||
            (map[0][2] == map[1][1]  && map[1][1] == map[2][0]  && map[2][0]== chr) ||
            (map[0][0] == map[1][0]  && map[1][0] == map[2][0]  && map[2][0]== chr) ||
            (map[0][1] == map[1][1]  && map[1][1] == map[2][1]  && map[2][1]== chr) ||
            (map[0][2] == map[1][2]  && map[1][2] == map[2][2]  && map[2][2]== chr) ;
  }
}
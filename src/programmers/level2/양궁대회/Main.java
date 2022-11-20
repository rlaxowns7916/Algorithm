package programmers.level2.양궁대회;

public class Main {
  class Solution {
    int diff = 0;
    int[] answer = new int[11];
    public int[] solution(int n, int[] info) {
      int[] ryan = new int[11];
      search(n,0,ryan,info);
      if(diff == 0){
        answer = new int[] {-1};
      }
      return answer;
    }

    public void search(int ryanRemain, int nowScore,int[] ryan, int[] apache){
      if(ryanRemain > 0 && nowScore < 10){
        if(ryanRemain > apache[nowScore]){
          ryan[nowScore] = apache[nowScore]+1;
          search(ryanRemain - ryan[nowScore],nowScore+1,ryan,apache);
          ryan[nowScore] = 0;
        }
        search(ryanRemain, nowScore+1,ryan,apache);
      }else if(ryanRemain == 0 || nowScore == 10){
        ryan[10] += ryanRemain;
        int nowDiff = calculate(ryan,apache);
        if((nowDiff > diff) || (nowDiff == diff && isLower(ryan))){
          diff = nowDiff;
          answer = copy(ryan);
        }
        ryan[10]  -= ryanRemain;
      }
    }
    public boolean isLower(int[] ryan){
      for(int i=10; i>=0;i--){
        if(ryan[i] > answer[i])
          return true;
        else if(answer[i] > ryan[i])
          return false;
      }
      return false;
    }
    public int[] copy(int[] origin){
      int[] copy = new int[11];
      for(int i = 0;i<=10;i++){
        copy[i] = origin[i];
      }
      return copy;
    }

    public int calculate(int[] ryanScore, int[] apacheScore){
      int ryan = 0, apache = 0;
      for(int i=0;i<10;i++){
        if(ryanScore[i] > apacheScore[i]){
          ryan += (10-i);
        }else if(apacheScore[i] >= ryanScore[i] && apacheScore[i] > 0){
          apache += (10-i);
        }
      }
      return ryan - apache;
    }
  }
}

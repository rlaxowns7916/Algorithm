package programmers.level2.점프와순간이동;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.solution(5000));;
  }
  public int solution(int n) {
    int count = 0;
    while(true){
      if(n % 2 != 0){
        n -=1;
        count++;
      }else{
        n/=2;
      }
      if(n == 0){
        break;
      }
    }
    return count;
  }
}

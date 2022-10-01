package programmers.level2.N진수게임;

class Main {
  /**
   * n: 진법 t: 숫자의 갯수 m: 인원 p: 순서
   */
  public String solution(int n, int t, int m, int p) {
    int count = 0;
    int num = 0;
    int turn = 0;
    StringBuilder sb = new StringBuilder();

    while (count < t) {
      String expression = getNumber(n, num);
      for (int j = 0; j < expression.length() && count < t; j++) {
        if (turn == p-1) {
          sb.append(expression.charAt(j));
          count++;
        }
        turn = (turn + 1) % m;
      }
      num++;
    }
    return sb.toString();
  }

  public String getNumber(int n, int num) {
    StringBuilder sb = new StringBuilder();
    if(num == 0)
      return "0";
    while (num > 0) {
      int rem = num % n;
      if (rem >= 10) {
        sb.append((char) ('A' + rem - 10));
      } else {
        sb.append(num % n);
      }
      num = num / n;
    }
    return sb.reverse().toString();
  }
}
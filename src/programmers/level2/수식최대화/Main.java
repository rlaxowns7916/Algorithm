package programmers.level2.수식최대화;

import java.util.ArrayList;
import java.util.Stack;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    System.out.println(main.solution("100-200*300-500+20"));
  }

  public long solution(String expression) {
    long answer = 0;
    ArrayList<Long> operands = new ArrayList<>();
    ArrayList<Character> operators = new ArrayList<>();
    separate(expression, operands, operators);

    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        if (i == j) {
          continue;
        }
        for (int k = 0; k < 3; k++) {
          if (i == k || j == k) {
            continue;
          }
          answer = Math.max(answer, Math.abs(calculateTotal(operands, operators, i, j, k)));
        }
      }
    }

    return answer;
  }
  public void separate(String expression, ArrayList<Long> operand,
      ArrayList<Character> operator) {
    int delimiterIndex = 0;
    for (int i = 1; i < expression.length(); i++) {
      char ch = expression.charAt(i);

      if ('0' <= ch && ch <= '9') {
        continue;
      } else {
        operand.add(Long.parseLong(expression.substring(delimiterIndex, i)));
        operator.add(ch);
        delimiterIndex = i + 1;
      }
    }
    operand.add(Long.parseLong(expression.substring(delimiterIndex)));
  }

  public long calculateTotal(ArrayList<Long> operands, ArrayList<Character> operators,
      int firstOp,
      int secondOp, int thirdOp) {
    char[] operator = {'+', '-', '*' };
    ArrayList<Long> copyOperands = new ArrayList<>(operands);
    ArrayList<Character> copyOperators = new ArrayList<>(operators);

    calculate(copyOperands,copyOperators,operator[firstOp]);
    calculate(copyOperands,copyOperators,operator[secondOp]);
    calculate(copyOperands,copyOperators,operator[thirdOp]);

    return copyOperands.get(0);
  }

  public void calculate(ArrayList<Long> operands, ArrayList<Character> operators,
      char nowOperator) {
    while (operands.size() != 1) {
      int operatorIndex = operators.indexOf(nowOperator);
      if (operatorIndex != -1) {
        long result = 0L;
        long firstOperand = operands.remove(operatorIndex);
        long secondOperand = operands.remove(operatorIndex);

        if (nowOperator == '+') {
          result = firstOperand + secondOperand;
        } else if (nowOperator == '-') {
          result = firstOperand - secondOperand;
        } else {
          result = firstOperand * secondOperand;
        }
        operands.add(operatorIndex, result);
        operators.remove(operatorIndex);
      }else
        break;
    }
  }
}

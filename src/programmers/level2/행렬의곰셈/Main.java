package programmers.level2.행렬의곰셈;

public class Main {
  class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
      int rowLen = arr1.length;
      int colLen = arr2[0].length;
      int[][] resultArray = new int[rowLen][colLen];

      for(int i=0;i<rowLen;i++){
        for(int j=0;j<colLen;j++){
          for(int k=0;k <arr2.length;k++){
            resultArray[i][j] += arr1[i][k] * arr2[k][j];
          }
        }
      }
      return resultArray;
    }
  }
}

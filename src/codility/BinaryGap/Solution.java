package codility.BinaryGap;

class Solution {
    public int solution(int N) {
        int max = 0;
        String binary = toBinary(N);
        char[] binaryArray = binary.toCharArray();

        for(int i=0;i<binaryArray.length - 1;i++){
            if(binaryArray[i] != '1'){continue;}
            for(int j=i+1;j<binaryArray.length;j++){
                if(binaryArray[j] == '1'){
                    max = Math.max(max,j-i-1);
                    break;
                }
            }
        }
        return max;
    }
    public String toBinary(int N){
        int current = N;
        StringBuilder sb = new StringBuilder();

        while(current != 0){
            sb.append(current % 2);
            current /= 2;
        }

        return sb.reverse().toString();
    }
}
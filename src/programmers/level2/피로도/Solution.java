package programmers.level2.피로도;


public class Solution {
    private int answer = 0;
    public int solution(int k, int[][] dungeons) {
        int[] sequence = new int[dungeons.length];
        for(int i=0;i<sequence.length;i++){
            sequence[i] = i;
        }

       solve(0,k,dungeons,sequence);

        return answer;
    }

    private void solve(int depth, int k,int[][] dungeons,  int[] sequence){
        if(depth == sequence.length){
            answer = Math.max(answer,calculate(dungeons, sequence,k));
        }else{
            for(int i = depth; i < sequence.length;i++){
                swap(sequence,i,depth);
                solve(depth + 1, k, dungeons, sequence);
                swap(sequence,depth,i);
            }
        }
    }

    private int calculate(int[][] dungeons, int[] sequence,int k){
        int count = 0;
        for(int index :sequence){
            if(k >= dungeons[index][0]){
                k -= dungeons[index][1];
                count++;
            }
        }

        return count;
    }

    private void swap(int[] arr, int a, int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}

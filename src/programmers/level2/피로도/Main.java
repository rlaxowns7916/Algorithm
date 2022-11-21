package programmers.level2.피로도;

public class Main {
    class Solution {
        int answer = 0;
        public int solution(int k, int[][] dungeons) {
            int numOfDungeons = dungeons.length;
            int[] sequence = new int[numOfDungeons];
            for(int i=0;i<numOfDungeons;i++){
                sequence[i] = i;
            }

            perm(0,numOfDungeons,sequence,k,dungeons);

            return answer;
        }
        public void perm(int dungeon, int numOfDungeons,int[]sequence, int k, int[][] dungeons){
            if(dungeon == numOfDungeons-1){
                answer = Math.max(answer,checkClear(k,sequence,dungeons));
            }else{
                for(int i=dungeon; i < numOfDungeons;i++){
                    swap(dungeon,i,sequence);
                    perm(dungeon+1,numOfDungeons,sequence,k,dungeons);
                    swap(dungeon,i,sequence);
                }
            }
        }

        public int checkClear(int k, int[] sequence, int[][] dungeons){
            int clear = 0;
            for(int turn : sequence){
                int[] dungeon = dungeons[turn];
                int need=  dungeon[0];
                int use = dungeon[1];

                if(k >= need){
                    k -= use;
                    clear++;
                }
            }
            return clear;
        }
        public void swap(int a, int b, int[] sequence){
            int num = sequence[a];
            sequence[a] = sequence[b];
            sequence[b] = num;
        }
    }
}

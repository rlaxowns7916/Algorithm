package programmers.level1.실패율;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public Integer[] solution(int N, int[] stages) {
        int[] challengerStageCount = new int[N+2];
        int[] totalStageCount = new int[N+2];
        List<StageFailure> stageFailures = new ArrayList<>();

        for(int stage: stages){
            challengerStageCount[stage]++;
        }

        totalStageCount[N+1] = challengerStageCount[N+1];
        for(int i=N; i>=1; i--){
            totalStageCount[i] = totalStageCount[i+1] + challengerStageCount[i];
        }

        for(int i=1; i<=N;i++){
            stageFailures.add(new StageFailure(i,challengerStageCount[i],totalStageCount[i]));
        }

        return stageFailures.stream()
                .sorted()
                .map(StageFailure::getStage)
                .toArray(Integer[]::new);
    }

    class StageFailure implements  Comparable<StageFailure>{
        private int stage;
        private double failureRate;

        public StageFailure(int stage, int challenger, int total){
            this.stage = stage;
            this.failureRate = total ==  0 ? 0 : (double) challenger / total;
        }

        public int getStage(){
            return this.stage;
        }

        @Override
        public int compareTo(StageFailure o) {

            if(this.failureRate == o.failureRate){
                return Integer.compare(this.stage, o.stage);
            }
            return Double.compare(o.failureRate,this.failureRate);
        }
    }
}

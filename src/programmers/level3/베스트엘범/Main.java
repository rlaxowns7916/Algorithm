package programmers.level3.베스트엘범;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.PriorityQueue;

public class Main {
    static class Solution {
        static class Music implements Comparable<Music>{
            int idx=0;
            int playTime=0;

            public Music(int idx,int playTime){
                this.idx = idx;
                this.playTime = playTime;
            }

            @Override
            public int compareTo(Music o){
                if(this.playTime == o.playTime)
                    return this.idx-o.idx;
                return  o.playTime- this.playTime;
            }
        }
        static class Info implements Comparable<Info>{
            int totalPlayTime=0;
            PriorityQueue<Music> pq = new PriorityQueue<>();

            @Override
            public int compareTo(Info o){
                return o.totalPlayTime - this.totalPlayTime;
            }
        }
        public int[] solution(String[] genres, int[] plays) {
            int len = genres.length;
            ArrayList<Integer> result = new ArrayList<>();
            HashMap<String,Info> map = new LinkedHashMap<>();
            PriorityQueue<Info> pq = new PriorityQueue<>();

            for(int i=0;i<len;i++){
                Music music = new Music(i,plays[i]);

                if(!map.containsKey(genres[i]))
                    map.put(genres[i],new Info());

                Info info = map.get(genres[i]);
                info.totalPlayTime +=plays[i];
                info.pq.add(music);
            }

            for(String key: map.keySet())
                pq.add(map.get(key));

            while(!pq.isEmpty()){
                Info info = pq.poll();
                for(int j=0;j<2;j++){
                    if(!info.pq.isEmpty())
                        result.add(info.pq.poll().idx);
                }
            }
            return result.stream().mapToInt(Integer::intValue).toArray();
        }
    }
}

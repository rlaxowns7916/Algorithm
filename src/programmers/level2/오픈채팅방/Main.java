package programmers.level2.오픈채팅방;

import java.util.*;

public class Main {
    class Solution {
        class Record{
            String uid;
            String command;

            public Record(String uid, String command){
                this.uid = uid;
                this.command = command;
            }
        }
        public Queue<Record> history = new LinkedList<>();
        public Map<String,String> users = new LinkedHashMap<>();

        public String[] solution(String[] records) {
            int count = 0;
            String command,uid,nickName;
            for(String record : records){
                StringTokenizer st = new StringTokenizer(record);
                command = st.nextToken();
                Record now;

                if(command.equals("Change") || command.equals("Enter")){
                    uid = st.nextToken();
                    nickName = st.nextToken();

                    now = new Record(uid,command);
                    users.put(uid,nickName);
                }else{
                    uid = st.nextToken();
                    now = new Record(uid,command);
                }
                history.add(now);
            }
            return print().toArray(new String[0]);
        }
        public List<String> print(){
            int count=0;
            ArrayList<String> answer = new ArrayList<>();
            while(!history.isEmpty()){
                Record record = history.poll();
                StringBuilder sb = new StringBuilder();

                String uid = record.uid;
                String command = record.command;
                String nickName = users.get(uid);

                if(record.command.equals("Change"))
                    continue;
                else if(record.command.equals("Enter")){
                    sb.append(nickName).append("님이 들어왔습니다.");
                }else{
                    sb.append(nickName).append("님이 나갔습니다.");
                }
                answer.add(sb.toString());
            }
            return answer;
        }
    }
}

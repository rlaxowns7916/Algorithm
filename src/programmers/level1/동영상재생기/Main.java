package programmers.level1.동영상재생기;

import java.util.StringTokenizer;

public class Main {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        Position position = new Position(pos, "00:00", video_len);
        Time openingStart = new Time(op_start);
        Time openingEnd = new Time(op_end);

        skipIfInOpening(position,openingStart,openingEnd);
        for(String command : commands){
            if(command.equals("prev")){
                position.minus(new Time("00:10"));
            }else{
                position.plus(new Time("00:10"));
            }
            skipIfInOpening(position,openingStart,openingEnd);
        }
        return position.toString();
    }

    private void skipIfInOpening(
        Position pos,
        Time openingStart,
        Time openingEnd
    ){
        if(pos.current.compareTo(openingStart) >= 0 && pos.current.compareTo(openingEnd) <= 0){
            pos.current.minute = openingEnd.minute;
            pos.current.second = openingEnd.second;
        }
    }

    static class Position{

        private final Time min;
        private final Time max;
        private final Time current;

        public Position(
            String pos,
            String min,
            String max
        ){
            this.current = new Time(pos);
            this.min = new Time(min);
            this.max  = new Time(max);
        }

        public void plus(Time time){
            current.plus(time);

            if(current.compareTo(max) > 0){
                current.minute = max.minute;
                current.second = max.second;
            }
        }

        public void minus(Time time){
            current.minus(time);

            if(current.compareTo(min) < 0){
                current.minute = min.minute;
                current.second = min.second;
            }
        }

        @Override
        public String toString(){
            return String.format("%02d:%02d", current.minute,current.second);
        }
    }

    static class Time implements Comparable<Time>{
        private int minute;
        private int second;

        public Time(String time){
            String[] tokens = time.split(":");

            minute = Integer.parseInt(tokens[0]);
            second = Integer.parseInt(tokens[1]);
        }

        public void plus(Time other){
            int total = this.toSecond() + other.toSecond();

            this.minute = total / 60;
            this.second = total % 60;
        }

        public void minus(Time other){
            int total = this.toSecond() - other.toSecond();

            if(total < 0){
                this.minute = this.second = 0;
            }else{
                this.minute = total / 60;
                this.second = total % 60;
            }
        }

        private int toSecond(){
            return 60 * minute + second;
        }

        @Override
        public int compareTo(Time o) {
            return Integer.compare(toSecond(), o.toSecond());
        }
    }
}

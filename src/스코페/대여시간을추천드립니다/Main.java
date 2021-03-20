package 스코페.대여시간을추천드립니다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class Main {
    public static int N = 0;
    public static SimpleDateFormat format = new SimpleDateFormat("HH:mm");
    public static ArrayList<String> startTime = new ArrayList<>();
    public static ArrayList<String> endTime = new ArrayList<>();

    public static void main(String[] args) throws IOException, ParseException {
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String start, end;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), "~");
            startTime.add(st.nextToken());
            endTime.add(st.nextToken());
        }
        start = getMax();
        end = getMin();

        if(format.parse(start).after(format.parse(end)))
            sb.append(-1);
        else
            sb.append(start).append(" ~ ").append(end);
        System.out.println(sb);

    }

    public static String getMin() throws ParseException {
        Date date = format.parse("23:59");

        for (String end : endTime) {
            Date target = format.parse(end);
            if (date.after(target))
                date = target;
        }
        return format.format(date);
    }

    public static String getMax() throws ParseException {
        Date date = format.parse("00:00");
        for (String start : startTime) {
            Date target = format.parse(start);
            if (date.before(target))
                date = target;
        }
        return format.format(date);
    }
}

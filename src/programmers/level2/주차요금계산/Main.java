package programmers.level2.주차요금계산;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {

  public static void main(String[] args) {

  }

  public Integer[] solution(int[] fees, String[] records) {
    int baseTime = 0, defaultFee = 0, parkTimeUnit = 0, parkFeeUnit = 0, carNumber = 0;
    String time = null, type = null;
    Map<Integer, LinkedList<Record>> parkRecords = new LinkedHashMap<>();
    ArrayList<Integer> result = new ArrayList<>();

    baseTime = fees[0];
    defaultFee = fees[1];
    parkTimeUnit = fees[2];
    parkFeeUnit = fees[3];

    for (int i = 0; i < records.length; i++) {
      StringTokenizer st = new StringTokenizer(records[i]);
      time = st.nextToken();
      carNumber = Integer.parseInt(st.nextToken());
      type = st.nextToken();
      if (!parkRecords.containsKey(carNumber)) {
        parkRecords.put(carNumber, new LinkedList<>());
      }
      parkRecords.get(carNumber).add(new Record(type, time));
    }

    List<Integer> sortedKey = parkRecords.keySet().stream().sorted().collect(Collectors.toList());

    for (Integer key : sortedKey) {
      LinkedList<Record> parkRecord = parkRecords.get(key);
      result.add(calculateTotal(parkRecord, baseTime, defaultFee, parkTimeUnit, parkFeeUnit));
    }

    return result.toArray(new Integer[0]);
  }

  public int calculateTotal(LinkedList<Record> records, int baseTime, int defaultFee,
      int parkTimeUnit, int parkFeeUnit) {
    int timeDiff = 0;
    Iterator<Record> it = records.iterator();

    while (it.hasNext()) {
      Record in = it.next();

      if (it.hasNext()) {
        Record out = it.next();
        timeDiff += getTimeDiff(in.time, out.time);
      } else {
        timeDiff += getTimeDiff(in.time, "23:59");
      }
    }
    return calculateInAndOut(timeDiff, baseTime, defaultFee, parkTimeUnit, parkFeeUnit);
  }


  public int calculateInAndOut(int timeDiff, int baseTime, int defaultFee,
      int parkTimeUnit, int parkFeeUnit) {
    int needToPayTime = timeDiff - baseTime;
    int timeUnit = needToPayTime % parkTimeUnit == 0 ? needToPayTime / parkTimeUnit
        : needToPayTime / parkTimeUnit + 1;
    return needToPayTime <= 0 ? defaultFee : defaultFee + timeUnit * parkFeeUnit;

  }

  public int getTimeDiff(String in, String out) {
    StringTokenizer st = new StringTokenizer(in, ":");
    int inTime = Integer.parseInt(st.nextToken()) * 60;
    int inMinute = Integer.parseInt(st.nextToken());

    st = new StringTokenizer(out, ":");
    int outTime = Integer.parseInt(st.nextToken()) * 60;
    int outMinute = Integer.parseInt(st.nextToken());

    return (outTime + outMinute) - (inTime + inMinute);
  }
}

class Record {

  String type;
  String time;

  public Record(String type, String time) {
    this.type = type;
    this.time = time;
  }
}

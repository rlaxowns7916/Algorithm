package 백준.나는야포켓몬마스터이다솜;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

  public static int N = 0, M = 0;

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    Map<Integer,String> indexMap = new LinkedHashMap<>();
    Map<String,Integer> nameMap = new LinkedHashMap<>();

    N = Integer.parseInt(st.nextToken());
    M = Integer.parseInt(st.nextToken());

    for(int i=1;i<=N;i++){
      String name = br.readLine();

      indexMap.put(i,name);
      nameMap.put(name,i);
    }

    for(int i=0;i<M;i++){
      String input = br.readLine();

      if(('a' <= input.charAt(0) && input.charAt(0) <='z') || ('A'<=input.charAt(0) && input.charAt(0) <= 'Z')){
        sb.append(nameMap.get(input));
      }else{
        sb.append(indexMap.get(Integer.parseInt(input)));
      }
      sb.append("\n");
    }
    System.out.println(sb);
  }
}

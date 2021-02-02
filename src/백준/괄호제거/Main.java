package 백준.괄호제거;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static class Pair{
        int open;
        int close;

        public Pair(int open,int close){
            this.open = open;
            this.close = close;
        }
    }
    public static ArrayList<Pair> store = new ArrayList();
    public static Set<String> ans = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str =br.readLine();

        System.out.println(solve(str));
    }
    public static String solve(String str)
    {
        PriorityQueue<String> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        getStore(str);
        boolean[] visit = new boolean[store.size()];
        comb(str,0,visit,0);

        for(String token:ans)
            pq.add(token);

        while(!pq.isEmpty())
            sb.append(pq.poll()).append("\n");
        return sb.toString();
    }
    public static void getStore(String str) {
        Stack<Integer> stack = new Stack();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '(')
                stack.push(i);
            else if(str.charAt(i) == ')')
                store.add(new Pair(stack.pop(),i));
        }
    }
    public static void comb(String str,int depth,boolean[] visit,int count){
        if(depth == store.size()){
            if(count > 0){
                int i=0;
                StringBuilder sb = new StringBuilder();
                boolean[] check = new boolean[str.length()];
                for(i=0;i<visit.length;i++){
                    if(visit[i]){
                        Pair pair = store.get(i);
                        check[pair.open]=check[pair.close]=true;
                    }
                }
                for(i=0;i<check.length;i++){
                    if(!check[i])
                        sb.append(str.charAt(i));
                }
                ans.add(sb.toString());
            }
        }else{
            visit[depth] = true;
            comb(str,depth+1,visit,count+1);
            visit[depth] = false;
            comb(str,depth+1,visit,count);
        }
    }
}

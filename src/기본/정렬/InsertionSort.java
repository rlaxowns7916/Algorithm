package 기본.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InsertionSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()),i=0,j=0;
        int[] arr =new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());
        sort(arr);
        for(i=0;i<N;i++)
            System.out.println(arr[i]);
    }
    public static void sort(int[] arr)
    {
        int i=0,start=0,target=0;

        for(start = 1;start<arr.length;start++){
            target = arr[start];
            for(i=0;i<start;i++){
                if(target < arr[i]){
                    move(arr,i,start);
                    arr[i] = target;
                    break;
                }
            }
        }
    }
    public static void move(int[] arr,int start, int end)
    {
        for(int i = end;i>start;i--)
            arr[i]=arr[i-1];
    }
}

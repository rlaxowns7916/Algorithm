package 기본.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()),i=0,j=0;
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        sort(arr);
        for(int element : arr)
            System.out.println(element);
    }
    public static void sort(int[] arr)
    {
        int i=0,j=0,lastChanged=0;
        for(i=0;i<arr.length;i++){
            boolean flag = true;
            for(j=arr.length-1;j>i;j--){
                if(arr[j] < arr[j-1]){
                    swap(arr,j-1,j);
                    lastChanged = j-1;
                    flag=false;
                }
            }
            i = lastChanged;
            if(flag) break;
        }
    }
    public static void swap(int[] arr,int i,int j){
        int tmp=0;

        tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}

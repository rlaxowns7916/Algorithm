package 기본.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSort {
    public static int N=0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        for(int i=0;i<N;i++)
            arr[i] = Integer.parseInt(st.nextToken());

        quickSort(arr,0,N-1);
        for(int num : arr)
            System.out.println(num);
    }
    public static int partition(int[] arr,int start,int end)
    {
        int i=start,j=end,pivot = arr[(start+end)/2];
            while(i<=j){
                while(arr[i] < pivot) i++;
                while(arr[j]> pivot) j--;

                if(i<=j)
                    swap(arr,i++,j--);
            }
            return i;
    }
    public static void quickSort(int[] arr,int start,int end)
    {
        int pivot = partition(arr,start,end);
        if(start < pivot-1)
            quickSort(arr,start,pivot-1);
        if(pivot+1<end)
            quickSort(arr,pivot+1,end);
    }
    public static void swap(int[] arr,int i,int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}

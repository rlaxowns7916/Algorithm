package 기본.정렬;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MergeSort {
    public static void main(String[] args) throws IOException {
        int n = 0;
        int[] arr;
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Input Array Length :");
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        System.out.print("Input Numbers :");
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        mergeSort(arr, 0, n - 1);
        for (int num : arr)
            sb.append(num).append(" ");
        System.out.println(sb);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        int mid = (start + end) / 2;
        if (start < end) {
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, end);
        }
    }

    public static void merge(int[] arr, int start, int end) {
        int idx = 0, len = end - start + 1;
        int mid = (start + end) / 2, left = start, right = mid + 1;
        int[] temp = new int[len];

        while (left <= mid && right <= end) {
            if (arr[left] < arr[right])
                temp[idx++] = arr[left++];
            else
                temp[idx++] = arr[right++];
        }
        while(left <= mid)
            temp[idx++] = arr[left++];
        while(right <= end)
            temp[idx++] = arr[right++];

        for (int i = 0; i < len; i++)
            arr[start + i] = temp[i];
    }
}

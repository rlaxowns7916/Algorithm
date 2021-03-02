package 백준.수찾기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int[] nums;
        int length, i = 0, target = 0;

        StringTokenizer st;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        length = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        nums = new int[length];

        for (i = 0; i < length; i++)
            nums[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(nums);

        length = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for (i = 0; i < length; i++) {
            target = Integer.parseInt(st.nextToken());
            if (nums[0] > target || nums[nums.length - 1] < target)
                sb.append(0).append("\n");
            else
                sb.append(binarySearch(nums, 0, nums.length, target)).append("\n");
        }
        System.out.println(sb.toString());
    }

    public static int binarySearch(int[] nums, int start, int end, int target) {
        int mid = (start + end) / 2;
        if (start <= end) {
            if (nums[mid] == target)
                return 1;
            else if (nums[mid] < target)
                return binarySearch(nums, mid + 1, end, target);
            else
                return binarySearch(nums, start, mid - 1, target);
        } else
            return 0;
    }
}

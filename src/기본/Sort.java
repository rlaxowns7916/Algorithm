package 기본;

public class Sort {

  public static void main(String[] args) {
    int[] numbers = {9, 7, 1, 6, 2, 4, 3, 2, 1};
    //new BubbleSort().sort(numbers);
    //new SelectionSort().sort(numbers);
    //new MergeSort().sort(numbers);
    new QuickSort().sort(numbers);
    for (int num : numbers) {
      System.out.println(num + " ");
    }
  }

}

class MergeSort {

  public void sort(int[] origin) {
    int left = 0, right = origin.length - 1;
    divide(origin, left, right);
  }

  private void divide(int[] origin, int left, int right) {
    if (left < right) {
      int mid = (left + right) / 2;
      divide(origin, left, mid);
      divide(origin, mid + 1, right);
      conquer(origin, left, right);
    }
  }

  private void conquer(int[] origin, int left, int right) {
    int i = 0, mid = (left + right) / 2, len = right - left + 1;
    int leftCnt = left, rightCnt = mid + 1;
    int[] subList = new int[len];

    while (i < len) {
      if (leftCnt <= mid) {
        if (rightCnt <= right) {
          subList[i++] =
              origin[leftCnt] > origin[rightCnt] ? origin[rightCnt++] : origin[leftCnt++];
        } else {
          subList[i++] = origin[leftCnt++];
        }
      } else {
        subList[i++] = origin[rightCnt++];
      }
    }

    for (i = 0; i < len; i++) {
      origin[left + i] = subList[i];
    }
  }

  private void swap(int[] origin, int x, int y) {
    int tmp = origin[x];
    origin[x] = origin[y];
    origin[y] = tmp;
  }
}

class QuickSort {

  public void sort(int[] origin) {
    solve(origin, 0, origin.length - 1);
  }

  private void solve(int[] origin, int left, int right) {
    if (left < right) {
      int pivot = partition(origin, left, right);
      solve(origin, left, pivot - 1);
      solve(origin, pivot + 1, right);
    }
  }

  private int partition(int[] origin, int left, int right) {
    int pivot = right;
    int i = left, j = pivot - 1;

    while (i < j) {
      if (origin[i] > origin[pivot]) {
        swap(origin, i, j--);
      } else {
        i++;
      }
    }
    swap(origin, j, pivot);
    return j;
  }

  private void swap(int[] origin, int x, int y) {
    int tmp = origin[x];
    origin[x] = origin[y];
    origin[y] = tmp;
  }
}

class SelectionSort {

  public void sort(int[] origin) {
    int target = 0;
    int len = origin.length;

    for (int i = 0; i < len - 1; i++) {
      target = i;
      for (int j = i + 1; j < len; j++) {
        if (origin[target] > origin[j]) {
          target = j;
        }
      }
      swap(origin, i, target);
    }
  }

  private void swap(int[] origin, int x, int y) {
    int tmp = origin[x];
    origin[x] = origin[y];
    origin[y] = tmp;
  }
}

class BubbleSort {

  public void sort(int[] origin) {
    int len = origin.length;

    for (int i = len - 1; i > 0; i--) {

      for (int j = 0; j < i; j++) {
        if (origin[j] > origin[j + 1]) {
          swap(origin, j, j + 1);
        }
      }
    }
  }

  private void swap(int[] origin, int x, int y) {
    int tmp = origin[x];
    origin[x] = origin[y];
    origin[y] = tmp;
  }
}

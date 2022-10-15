package 기본;


public class Heap {

  public static void main(String[] args) {
    int size = 15;
    int[] arr = new int[size + 1];
    StringBuilder sb = new StringBuilder();

    sb.append("Before Sort :");
    for (int i = 1; i <= size; i++) {
      arr[i] = (int) (Math.random() * 100) + 1;
      sb.append(arr[i]).append(" ");
    }

    sort(arr);
    sb.append("\n").append("After Sort: ");
    for (int i = size; i > 0; i--) {
      sb.append(poll(arr, i)).append(" ");
    }
    System.out.println(sb);
  }

  public static void sort(int[] arr) {
    int size = arr.length;

    for (int i = size; i > 0; i--) {
      heapify(arr, i, size);
    }
  }

  public static int poll(int[] arr, int size) {
    int current = arr[1];
    arr[1] = arr[size];
    heapify(arr, 1, size);

    return current;
  }

  public static void heapify(int[] arr, int index, int size) {
    int parent = index;
    int leftChild = index * 2, rightChild = leftChild + 1;

    if (leftChild < size && arr[parent] < arr[leftChild]) {
      parent = leftChild;
    }

    if (rightChild < size && arr[parent] < arr[rightChild]) {
      parent = rightChild;
    }

    if (parent != index) {
      swap(arr, parent, index);
      heapify(arr, parent,size);
    }

  }

  public static void swap(int[] arr, int x, int y) {
    int tmp = arr[x];
    arr[x] = arr[y];
    arr[y] = tmp;
  }

}
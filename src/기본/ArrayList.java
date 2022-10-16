package 기본;

import java.util.Arrays;

public class ArrayList<T> {

  public static void main(String[] args) {
    ArrayList<Integer> arrayList = new ArrayList<>();

    for (int i = 0; i < 20; i++) {
      arrayList.add(i);
    }
    arrayList.add(1, 6);
    arrayList.add(2, 6);
    for (int i = 0; i < 20; i++) {
      System.out.println(arrayList.get(i));
    }
    System.out.println(arrayList.getSize());
  }


  private int DEFAULT_CAPACITY = 5;
  private int count = 0;
  private Object[] buffer = new Object[DEFAULT_CAPACITY];

  public T get(int index) {
    if (buffer.length <= index) {
      throw new IndexOutOfBoundsException("BufferSize :" + buffer.length + " And Index : " + index);
    }
    return (T) (buffer[index]);
  }

  public int getSize() {
    return this.count;
  }

  public <T> void add(T data) {
    this.add(data, count);
  }

  public <T> void add(T data, int index) {
    if (index > count) {
      throw new IndexOutOfBoundsException("BufferSize :" + count + " And Index : " + index);
    } else if (count + 1 == buffer.length - 1) {
      increaseBuffer();
    }
    System.arraycopy(buffer, index, buffer, index + 1, count - index + 1);
    buffer[index] = data;
    count++;
  }

  private void increaseBuffer() {
    int currentBufferSize = buffer.length;
    buffer = Arrays.copyOf(buffer, currentBufferSize * 2);
  }
}

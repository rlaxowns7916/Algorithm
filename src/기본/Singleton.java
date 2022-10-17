package 기본;

import java.util.Objects;
import java.util.Stack;

public class Singleton {

  public static void main(String[] args) {
    Node_NonThreadSafe node1 = Node_NonThreadSafe.getInstance();
    System.out.println(node1.getName());
  }

}

/**
 * 왜 Non-ThreadSafe인가? if문을 동시에 통과할 위험이 있다. 동시에 접근할 경우, 유일한 객체가 리턴되는 것을 보장 할 수 없다.
 */
class Node_NonThreadSafe {

  private final String name = "Singleton_NonThreadSafe";

  private static Node_NonThreadSafe instance = null;

  public static Node_NonThreadSafe getInstance() {
    if (instance == null) {
      instance = new Node_NonThreadSafe();
    }
    return instance;
  }

  public String getName() {
    return this.name;
  }

  private Node_NonThreadSafe() {

  }
}

/**
 * Synchronized를 통해서 객체의 유일성은 보장 가능하다. 하지만 Synchronized로 인해서 이미 유일한 객체를 생성 했음에도, 메소드 블록자체가
 * Blocking에걸리게된다. 리소스 낭비가 심각하다.
 */
class Node_Synchronized {

  private final String name = "Signeton_ThreadSafeWithBlocking";

  private static Node_Synchronized instance = null;

  public synchronized static Node_Synchronized getInstance() {
    if (Objects.isNull(instance)) {
      instance = new Node_Synchronized();
    }
    return instance;
  }

  private Node_Synchronized() {

  }
}

/**
 * Thread의 가시성문제는 해결가능하다. (값이 변경 되었을 때 각 Thread가 일관성있는 값을 볼 수 있게 해준다.) 하지만 완벽하게 동시성문제를 해결하지는 못한다.
 * (결국 수정은 Read -> Write 이다. Write를 하기위해 읽어온 중간에 값이 변경되는등의 문제는 해결하지 못한다.)
 */
class Node_Volatile {

  private static volatile Node_Volatile instance = null;

  private final String name = "Singlteon_PartialThreadSafeWithVolatile";

  public static Node_Volatile getInstance() {
    return instance;
  }

  private Node_Volatile() {

  }
}

/**
 * DoubleCheckLocking Null일 때, 생성하는 부분을 synchronized 블록으로 감싼다. 이 synchronized에는 하나의 Thread밖에 접근 할 수
 * 없는데, 이 안에서 다시 null check를 하여, 첫번째 이후의 Thread가 접근할 때는 로직을 생략시킨다.
 */
class Node_DoubleCheckLocking {

  private static Node_DoubleCheckLocking instance = null;

  public static Node_DoubleCheckLocking getInstance() {
    if (Objects.isNull(instance)) {
      synchronized (Node_DoubleCheckLocking.class) {
        if (Objects.isNull(instance)) {
          instance = new Node_DoubleCheckLocking();
        }
      }
    }
    return instance;
  }
  private Node_DoubleCheckLocking() {

  }
}

/**
 * Bill Pugh Solution Singleton 구현에 있어서 권장되는 방식이다. ThreadSafe하며, Dobule Check Locking보다 구현이 간단하다.
 * InnerClass와 Static Class의 특성을 사용한다.
 * Class는 사용될 때 로드된다. getInstance()가 호출될 때, 클래스에 접근하기 때문에, LazyLoading도 가능하다.
 * inner static은 외부 instacne에서 접근할 수 없다. --> 즉 외부 instance의 초기화로는 초기화되지 않는다. (직접 접근해야 초기화된다.)
 * 객체의 유일성을 보장 할 수 있다.
 */
class Node_BillPughSolution {

  private static class SingletonHelper {
    private static Node_BillPughSolution instance = new Node_BillPughSolution();

  }

  public static Node_BillPughSolution getInstance() {
    return SingletonHelper.instance;
  }

  private Node_BillPughSolution() {

  }
}
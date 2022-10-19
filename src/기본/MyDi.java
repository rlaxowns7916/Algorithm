package 기본;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;

public class MyDi {

  public static void main(String[] args) {
    BeanService beanService = MyApplicationContext.getBean(BeanService.class);
    BeanRepository beanRepository = MyApplicationContext.getBean(BeanRepository.class);

    System.out.println(beanService.beanRepository);
    System.out.println(beanRepository);
    System.out.println(beanService.beanRepository == beanRepository);

    NonBeanService nonBeanService = MyApplicationContext.getBean(NonBeanService.class);

  }
}

class MyApplicationContext {

  private static final ConcurrentHashMap<Class<?>, Object> singletonContainer = new ConcurrentHashMap<>();

  public static <T> T getBean(Class<T> clazz) {
    try {
      if (clazz.getDeclaredAnnotation(MyBean.class) == null) {
        throw new IllegalArgumentException(clazz.getTypeName() + " is Not Bean!");
      } else if (singletonContainer.containsKey(clazz)) {
        return (T) singletonContainer.get(clazz);
      }
      T newInstance = clazz.getConstructor().newInstance();

      Field[] fields = clazz.getDeclaredFields();
      for (Field field : fields) {
        field.setAccessible(true);
        if (field.getDeclaredAnnotation(MyAutowired.class) == null) {
          continue;
        }
        Object subBean = singletonContainer.containsKey(field.getType()) ?
            singletonContainer.get(field.getType())
            : MyApplicationContext.getBean(field.getType());
        System.out.println("Construction" + subBean);
        field.set(newInstance, subBean);
      }
      singletonContainer.put(clazz, newInstance);
      return newInstance;
    } catch (Exception e) {
      e.printStackTrace();
      throw new RuntimeException(e.getMessage());
    }
  }
}


@MyBean
class BeanService {

  @MyAutowired
  BeanRepository beanRepository = null;

  public BeanService() {

  }
}

@MyBean
class BeanRepository {

  public BeanRepository() {

  }
}

class NonBeanService {

  private NonBeanRepository nonBeanRepository;
}

class NonBeanRepository {

}


@Target(value = ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface MyBean {

}

@Target(value = ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAutowired {

}
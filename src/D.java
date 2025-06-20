import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class D {
    public static Integer[] main(String[] args) {
        Set<Integer> result = new HashSet<>();

        return result.stream().sorted().toArray(Integer[]::new);
    }
}

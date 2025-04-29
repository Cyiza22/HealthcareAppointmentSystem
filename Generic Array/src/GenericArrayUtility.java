import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericArrayUtility<T> {

    public static <T> List<T> mergeArrays(T[] a, T[] b){
        List<T> sum = new ArrayList<>();
        Collections.addAll(sum, a);
        Collections.addAll(sum, b);
        return sum;
    }

}

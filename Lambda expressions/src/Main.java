//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("Original List: " + numbers1);
        System.out.println("Even Numbers List: " + EvenNumberFilter.filterEvenNumbers(numbers1));
        System.out.println();

        // Test Case 2: Empty list
        List<Integer> numbers2 = Collections.emptyList();
        System.out.println("Original List: " + numbers2);
        System.out.println("Even Numbers List: " + EvenNumberFilter.filterEvenNumbers(numbers2));
        System.out.println();

        // Test Case 3: Only odd numbers
        List<Integer> numbers3 = Arrays.asList(1, 3, 5, 7, 9);
        System.out.println("Original List: " + numbers3);
        System.out.println("Even Numbers List: " + EvenNumberFilter.filterEvenNumbers(numbers3));
    }
}
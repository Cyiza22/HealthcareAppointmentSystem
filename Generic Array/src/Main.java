//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer[] a = {1, 2, 3};
        Integer[] b = {4, 5, 6};
        System.out.println("Merged Integer List: " + GenericArrayUtility.mergeArrays(a, b));

        String[] x = {"apple", "banana"};
        String[] y = {"cherry", "date"};
        System.out.println("Merged String List: " + GenericArrayUtility.mergeArrays(x, y));

    }
}
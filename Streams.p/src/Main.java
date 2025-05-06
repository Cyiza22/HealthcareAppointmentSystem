import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "people.csv";


        Files.write(Paths.get(filePath),
                ("Name,Age\n" +
                        "Alice,30\n" +
                        "Bob,25\n" +
                        "Charlie,40\n" +
                        "David,35\n" +
                        "Eve,28\n").getBytes());

        double averageAge = CSVStreamProcessor.calculateAverageAge(filePath);
        System.out.printf("The average age is %.2f%n", averageAge);

    }
}
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.OptionalDouble;
import java.util.stream.Stream;

public class CSVStreamProcessor {

    public static double calculateAverageAge(String csvFilePath) throws IOException {
        try (Stream<String> lines = Files.lines(Paths.get(csvFilePath))) {
            OptionalDouble average = lines
                    .skip(1)
                    .map(line -> line.split(","))
                    .filter(parts -> parts.length >= 2)
                    .map(parts -> {
                        try {
                            return Integer.parseInt(parts[1].trim());
                        } catch (NumberFormatException e) {
                            return null;
                        }
                    })
                    .filter(age -> age != null)
                    .mapToInt(Integer::intValue)
                    .average();

            return average.orElse(0.0);
        }
    }
}







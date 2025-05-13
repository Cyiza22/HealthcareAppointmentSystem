import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class CSVStream2Processor{

    public static double calculateAverageAge(String csvFilePath) throws IOException{
        try
                (Stream<String> lines = Files.lines(Paths.get(csvFilePath))) {
            return lines
                    .skip(1) // Skip header
                    .filter(age -> age != null)
                    .map(line -> line.split(","))
                    .mapToInt(fields -> Integer.parseInt(fields[1])) // Assuming age is in the second column
                    .average()
                    .orElse(0.0);

        }
        catch(NumberFormatException e){
            System.out.println("Error parsing age: " + e.getMessage());
            return 0.0;
        }
        catch(IOException e){
            System.out.println("Error reading file: " + e.getMessage());
            return 0.0;
        }
        finally{
            System.out.println("Finished processing the CSV file.");
    }
}
    public static void main(String[] args) throws IOException {
        double averageAge = CSVStreamProcessor.calculateAverageAge("C:\\Users\\irako\\IdeaProjects\\Projects\\Streams.p\\src\\people.csv");
        System.out.println("Average Age = " + String.format("%.2f", averageAge));
}
}




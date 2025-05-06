import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Stream;

import static java.util.Locale.filter;


public class CSVStreamProcessor {
    public static double calculateAverageAge(String csvFilePath) throws {
        try
                (Stream<String> lines = Files.lines(Paths.get(csvFilePath)))  {
            return lines
                    .skip( n: 1)
            .filter( String age -> age != null) Stream<String>
            .Map(String line -> line.split( regex: ",")) Stream<String[]>
            .MapToInt( S)

        }
    }





    }

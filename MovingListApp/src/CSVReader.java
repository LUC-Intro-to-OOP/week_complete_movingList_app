import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class CSVReader {
    public static List<String> readCSV(String filePath) {
        List<String> items = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                items.add(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return items;
    }
}


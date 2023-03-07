import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class PIBApp {
    
    public static void main(String[] args) {
        String filename = "pib.txt";
        Map<String, Double> pibs = readPibsFromFile(filename);
        double totalPib = calculateTotalPib(pibs);
        printPibPercentages(pibs, totalPib);
    }
    
    private static Map<String, Double> readPibsFromFile(String filename) {
        Map<String, Double> pibs = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String state = parts[0].trim();
                double pib = Double.parseDouble(parts[1].trim());
                pibs.put(state, pib);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pibs;
    }
    
    private static double calculateTotalPib(Map<String, Double> pibs) {
        double totalPib = 0;
        for (double pib : pibs.values()) {
            totalPib += pib;
        }
        return totalPib;
    }
    
    private static void printPibPercentages(Map<String, Double> pibs, double totalPib) {
        System.out.println("PIB por estado em percentual em relação ao total:");
        for (String state : pibs.keySet()) {
            double pib = pibs.get(state);
            double percentage = pib / totalPib * 100;
            System.out.printf("%s: %.2f%%\n", state, percentage);
        }
    }
}
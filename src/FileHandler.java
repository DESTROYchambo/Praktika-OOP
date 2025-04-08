package ex7;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Клас робоит з файлами
 *
 * @author Oleksandr
 */
public class FileHandler {

    private static final String FILENAME = "PROGRAMresults.txt";

    /**
     * Збереження результатів у файл.
     *
     * @param results список об'єктів EnergyResult
     * @throws IOException
     */
    public static void saveResults(List<EnergyResult> results) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (EnergyResult result : results) {
                writer.println(result.toFileString());
            }
        }
    }

    /**
     * Завантаженя результатів з файлу.
     *
     * @return список об'єктів EnergyResult
     * @throws IOException
     */
    public static List<EnergyResult> loadResults() throws IOException {
        List<EnergyResult> results = new ArrayList<>();
        File file = new File(FILENAME);

        if (!file.exists()) {
            return results;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                results.add(EnergyResult.fromFileString(line));
            }
        }
        return results;
    }
}

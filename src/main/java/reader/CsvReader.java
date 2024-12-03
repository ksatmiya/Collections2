package reader;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

    /**
     * Читает CSV файл
     * @param filePath путь к файлу
     * @return список с масивом строк
     */
    public static List<String[]> readCsvFile(String filePath) {
        List<String[]> data = new ArrayList<>();

        try (CSVReader csvReader = new CSVReaderBuilder(new FileReader(filePath))
                .withCSVParser(new CSVParserBuilder()
                        .withSeparator(';').build())
                .build()) {

            csvReader.readNext();

            String[] values;
            while ((values = csvReader.readNext()) != null) {
                data.add(values);
            }
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException(e);
        }

        return data;
    }
}

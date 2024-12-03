package reader;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class CsvReaderTest {


    //Будем считывать первую строку csv файла
    @Test
    @DisplayName("Test csv reader")
    public void testCsvReader() {
        String filePath = "src/main/resources/foreign_names.csv";

        List<String[]> result = CsvReader.readCsvFile(filePath);

        assertEquals(new String[]{"28281", "Aahan", "Male", "15.05.1970", "I", "4800"}, result.get(0));
    }

    @Test
    @DisplayName("Test reading empty CSV file")
    public void testReadCsvFile_EmptyFile() {
        String filePath = "src/test/resources/test.csv";

        List<String[]> result = CsvReader.readCsvFile(filePath);

        assertTrue(result.isEmpty());

    }

    @Test
    @DisplayName("Test reading csv file is throws")
    public void testReadCsvFile_Throws() {
        String filePath = "src/main/resources/";
        assertThrows(RuntimeException.class, () -> CsvReader.readCsvFile(filePath));
    }

}

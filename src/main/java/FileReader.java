
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class FileReader {
    static String readFromFile(String fileName) {
        return readFromFile(fileName, true);
    }
    public static String readFromFile(String fileName, boolean addNewLine) {
        try {
           return Files.readString(Path.of("myPatients.json"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void writeToFile(String fileName, Hospital hospital) throws IOException {
        new ObjectMapper().writeValue(new File("myPatients.json"), hospital);

    }
}

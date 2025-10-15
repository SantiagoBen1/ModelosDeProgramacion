package subsystem;

import java.io.BufferedWriter;
import java.io.IOException;

public class FileWriter {
    public void write(String fileName, String content) {
        try (BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(fileName))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}



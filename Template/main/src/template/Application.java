package template;

import java.util.Arrays;
import java.util.List;

/**
 * Punto de entrada que demuestra el uso del patrón Template Method.
 */
public class Application {

    public static void main(String[] args) {
        List<DocumentMiner> miners = Arrays.asList(
                new DocDocumentMiner(),
                new CsvDocumentMiner(),
                new PdfDocumentMiner()
        );

        List<String> sampleFiles = Arrays.asList(
                "contrato.doc",
                "personal.csv",
                "memorandum.pdf"
        );

        for (int i = 0; i < miners.size(); i++) {
            DocumentMiner miner = miners.get(i);
            String file = sampleFiles.get(i);
            String report = miner.extractRelevantInformation(file);
            System.out.println(report);
            System.out.println("------------------------------");
        }
    }
}

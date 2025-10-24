package template;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Implementación concreta para archivos CSV.
 */
public class CsvDocumentMiner extends DocumentMiner {

    private String extractedContent;

    @Override
    protected void loadFile(String filePath) {
        System.out.println("Cargando archivo CSV desde " + filePath);
    }

    @Override
    protected String parseDocument() {
        extractedContent = "departamento,empleados,costos\n" +
                "marketing,15,23000\n" +
                "ventas,20,42000\n" +
                "it,8,15000";
        return extractedContent;
    }

    @Override
    protected String formatReport(Map<String, Integer> metrics) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Resumen para CSV: " + getCurrentFile());
        joiner.add("- columnas detectadas: 3");
        metrics.forEach((key, value) -> joiner.add("- " + key + ": " + value));
        return joiner.toString();
    }
}

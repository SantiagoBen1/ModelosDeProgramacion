package template;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Implementación concreta para archivos PDF.
 */
public class PdfDocumentMiner extends DocumentMiner {

    private String extractedContent;

    @Override
    protected void loadFile(String filePath) {
        System.out.println("Cargando archivo PDF desde " + filePath);
    }

    @Override
    protected String parseDocument() {
        extractedContent = "Reporte financiero consolidado. EBITDA 12.5%. Proyección: 18%";
        return extractedContent;
    }

    @Override
    protected String formatReport(Map<String, Integer> metrics) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Resumen para PDF: " + getCurrentFile());
        metrics.forEach((key, value) -> joiner.add("- " + key + ": " + value));
        return joiner.toString();
    }
}

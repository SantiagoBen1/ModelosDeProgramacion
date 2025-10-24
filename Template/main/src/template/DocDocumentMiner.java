package template;

import java.util.Map;
import java.util.StringJoiner;

/**
 * Implementación concreta que conoce las particularidades de los documentos DOC.
 */
public class DocDocumentMiner extends DocumentMiner {

    private String extractedContent;

    @Override
    protected void loadFile(String filePath) {
        // En un escenario real aquí se utilizaría una librería como Apache POI.
        System.out.println("Cargando archivo DOC desde " + filePath);
    }

    @Override
    protected String parseDocument() {
        // Simulamos la lectura del contenido con información ficticia.
        extractedContent = "Informe de ventas Q1 2025. Clientes: 120. Ingresos: 450000 USD.";
        return extractedContent;
    }

    @Override
    protected String formatReport(Map<String, Integer> metrics) {
        StringJoiner joiner = new StringJoiner(System.lineSeparator());
        joiner.add("Resumen para DOC: " + getCurrentFile());
        metrics.forEach((key, value) -> joiner.add("- " + key + ": " + value));
        return joiner.toString();
    }

    @Override
    protected boolean shouldAudit() {
        return true;
    }
}

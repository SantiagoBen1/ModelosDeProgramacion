package template;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/**
 * Base class that encapsulates the shared algorithm for mining corporate documents.
 * Subclasses provide the steps that depend on the concrete document format
 * (e.g. how the file is loaded and parsed) while the common data processing logic
 * remains here.
 */
public abstract class DocumentMiner {

    private String currentFile;

    /**
     * Template method that describes the full data mining workflow.
     * Concrete steps are delegated to subclasses when they relate to a specific format.
     *
     * @param filePath path or name of the file to process
     * @return human readable summary of the extracted information
     */
    public final String extractRelevantInformation(String filePath) {
        currentFile = filePath;
        log("Iniciando extracción para " + filePath);

        loadFile(filePath);
        String rawContent = parseDocument();
        String cleanedContent = cleanContent(rawContent);
        Map<String, Integer> metrics = analyzeContent(cleanedContent);
        String report = formatReport(metrics);

        if (shouldAudit()) {
            audit(metrics);
        }

        log("Extracción finalizada para " + filePath);
        return report;
    }

    /**
     * Carga el archivo desde disco, red o cualquier almacenamiento intermedio.
     */
    protected abstract void loadFile(String filePath);

    /**
     * Conversión del archivo a una representación intermedia que permita analizarlos.
     */
    protected abstract String parseDocument();

    /**
     * Cada formato puede formatear el reporte final como considere apropiado.
     */
    protected abstract String formatReport(Map<String, Integer> metrics);

    /**
     * Hook que permite decidir si se desea registrar una auditoría.
     * Las subclases pueden sobrescribirlo para habilitar la auditoría.
     */
    protected boolean shouldAudit() {
        return false;
    }

    /**
     * Limpieza básica que elimina caracteres ruidosos y normaliza espacios.
     * Este paso es compartido por todos los formatos.
     */
    protected String cleanContent(String rawContent) {
        if (rawContent == null) {
            return "";
        }

        String normalized = rawContent
                .replaceAll("[\\r\\t]", " ")
                .replaceAll("[^a-zA-Z0-9,.;: ]", " ")
                .replaceAll(" +", " ")
                .trim()
                .toLowerCase(Locale.ROOT);

        log("Contenido normalizado");
        return normalized;
    }

    /**
     * Paso común que calcula métricas simples sobre el contenido normalizado.
     */
    protected Map<String, Integer> analyzeContent(String cleanedContent) {
        Map<String, Integer> metrics = new HashMap<>();
        if (cleanedContent.isEmpty()) {
            metrics.put("palabras", 0);
            metrics.put("oraciones", 0);
            metrics.put("numeros", 0);
            return metrics;
        }

        int wordCount = cleanedContent.split(" ").length;
        int sentenceCount = cleanedContent.split("[.;:]").length;
        int numericCount = cleanedContent.split("[0-9]+").length - 1;

        metrics.put("palabras", wordCount);
        metrics.put("oraciones", sentenceCount);
        metrics.put("numeros", numericCount);
        log("Análisis completado");
        return metrics;
    }

    /**
     * Auditoría simple que imprime las métricas calculadas.
     * Subclases pueden sobrescribir este método si requieren un comportamiento distinto.
     */
    protected void audit(Map<String, Integer> metrics) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        log("AUDITORÍA " + timestamp + " -> " + metrics);
    }

    protected String getCurrentFile() {
        return currentFile;
    }

    private void log(String message) {
        System.out.println("[" + getClass().getSimpleName() + "] " + message);
    }
}

// ---------------- INTERFACE ----------------
/**
 * La interface Document define el comportamiento común
 * que tendrán todos los documentos de la editorial.
 * 
 * Todos los documentos deben poder:
 * - Abrirse (open)
 * - Procesarse (process)
 */
interface Document {
    void open();    // Método para abrir el documento
    void process(); // Método para procesar el documento
}

// ---------------- CONCRETE PRODUCTS ----------------
/**
 * Cada clase concreta implementa la interfaz Document.
 * Representan los distintos formatos soportados por la empresa.
 */

// Documento Word
class WordDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abriendo documento Word.");
    }

    @Override
    public void process() {
        System.out.println("Procesando documento Word: validación, extracción de metadatos, generación de reportes.");
    }
}

// Documento PDF
class PDFDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abriendo documento PDF.");
    }

    @Override
    public void process() {
        System.out.println("Procesando documento PDF: validación, extracción de metadatos, generación de reportes.");
    }
}

// Documento Excel
class ExcelDocument implements Document {
    @Override
    public void open() {
        System.out.println("Abriendo documento Excel.");
    }

    @Override
    public void process() {
        System.out.println("Procesando documento Excel: validación, extracción de metadatos, generación de reportes.");
    }
}

// ---------------- CREATOR ----------------
/**
 * DocumentFactory es la clase creadora abstracta.
 * 
 * Define el método factory `createDocument()`, que será
 * implementado por las fábricas concretas.
 * 
 * El cliente no conoce qué tipo de documento crea, solo
 * sabe que recibirá un objeto que implementa Document.
 */
abstract class DocumentFactory {
    public abstract Document createDocument();
}

// ---------------- CONCRETE CREATORS ----------------
/**
 * Cada fábrica concreta sobrescribe el método factory
 * y devuelve una instancia del documento correspondiente.
 */

// Fábrica para documentos Word
class WordDocFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new WordDocument();
    }
}

// Fábrica para documentos PDF
class PDFDocFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new PDFDocument();
    }
}

// Fábrica para documentos Excel
class ExcelDocFactory extends DocumentFactory {
    @Override
    public Document createDocument() {
        return new ExcelDocument();
    }
}

// ---------------- CLIENT ----------------
/**
 * La clase cliente (Main) representa el sistema principal.
 * 
 * El cliente:
 * - NO conoce las clases concretas (WordDocument, PDFDocument, ExcelDocument).
 * - SOLO conoce la interfaz Document y la clase abstracta DocumentFactory.
 * 
 * Así garantizamos bajo acoplamiento y alta extensibilidad.
 */
public class Main {
    public static void main(String[] args) {
        // ================== EJEMPLO DE USO ==================
        // El cliente elige qué fábrica utilizar según el formato del documento.

        // Crear fábricas para cada tipo de documento
        DocumentFactory wordFactory = new WordDocFactory();
        DocumentFactory pdfFactory = new PDFDocFactory();
        DocumentFactory excelFactory = new ExcelDocFactory();

        // Usamos las fábricas para crear documentos
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();
        wordDoc.process();

        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();
        pdfDoc.process();

        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
        excelDoc.process();
    }
}
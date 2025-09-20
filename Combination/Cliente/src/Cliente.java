import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;

// ---------------- INTERFACES ----------------
interface Entrada {
    String ingresarString(String mensaje);
    boolean ingresarBoolean(String mensaje);
    int ingresarInt(String mensaje);
    float ingresarFloat(String mensaje);
    double ingresarDouble(String mensaje);
}

interface Salida {
    void mostrarString(String dato);
    void mostrarBoolean(boolean dato);
    void mostrarInt(int dato);
    void mostrarFloat(float dato);
    void mostrarDouble(double dato);
}

// Abstract Factory
interface IOFactory {
    Entrada crearEntrada();
    Salida crearSalida();
}

// ---------------- IMPLEMENTACIONES DE CONSOLA ----------------
class ConsoleEntrada implements Entrada {
    private final java.util.Scanner sc = new java.util.Scanner(System.in);

    @Override
    public String ingresarString(String mensaje) {
        System.out.print(mensaje + ": ");
        return sc.nextLine();
    }
    
    @Override
    public boolean ingresarBoolean(String mensaje) {
        while (true) {
            System.out.print(mensaje + " (true/false): ");
            String input = sc.nextLine().toLowerCase();
            if (input.equals("true") || input.equals("false")) {
                return Boolean.parseBoolean(input);
            }
            System.out.println("Por favor, ingrese 'true' o 'false'.");
        }
    }
    
    @Override
    public int ingresarInt(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número entero válido.");
            }
        }
    }
    
    @Override
    public float ingresarFloat(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Float.parseFloat(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }
    
    @Override
    public double ingresarDouble(String mensaje) {
        while (true) {
            System.out.print(mensaje + ": ");
            try {
                return Double.parseDouble(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, ingrese un número decimal válido.");
            }
        }
    }
}

class ConsoleSalida implements Salida {
    @Override
    public void mostrarString(String dato) {
        System.out.println("String: " + dato);
    }
    
    @Override
    public void mostrarBoolean(boolean dato) {
        System.out.println("Boolean: " + dato);
    }
    
    @Override
    public void mostrarInt(int dato) {
        System.out.println("Int: " + dato);
    }
    
    @Override
    public void mostrarFloat(float dato) {
        System.out.println("Float: " + dato);
    }
    
    @Override
    public void mostrarDouble(double dato) {
        System.out.println("Double: " + dato);
    }
}

// ---------------- IMPLEMENTACIONES FRAME (JOptionPane) ----------------
class EntradaFrame implements Entrada {
    @Override
    public String ingresarString(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }
    
    @Override
    public boolean ingresarBoolean(String mensaje) {
        while (true) {
            String input = JOptionPane.showInputDialog(mensaje + " (true/false)");
            if (input != null && (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"))) {
                return Boolean.parseBoolean(input);
            }
            JOptionPane.showMessageDialog(null, "Por favor, ingrese 'true' o 'false'.");
        }
    }
    
    @Override
    public int ingresarInt(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) return 0; // Cancelado
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número entero válido.");
            }
        }
    }
    
    @Override
    public float ingresarFloat(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) return 0; // Cancelado
                return Float.parseFloat(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número decimal válido.");
            }
        }
    }
    
    @Override
    public double ingresarDouble(String mensaje) {
        while (true) {
            try {
                String input = JOptionPane.showInputDialog(mensaje);
                if (input == null) return 0; // Cancelado
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Por favor, ingrese un número decimal válido.");
            }
        }
    }
}

class FrameSalida implements Salida {
    @Override
    public void mostrarString(String dato) {
        JOptionPane.showMessageDialog(null, "String: " + dato);
    }
    
    @Override
    public void mostrarBoolean(boolean dato) {
        JOptionPane.showMessageDialog(null, "Boolean: " + dato);
    }
    
    @Override
    public void mostrarInt(int dato) {
        JOptionPane.showMessageDialog(null, "Int: " + dato);
    }
    
    @Override
    public void mostrarFloat(float dato) {
        JOptionPane.showMessageDialog(null, "Float: " + dato);
    }
    
    @Override
    public void mostrarDouble(double dato) {
        JOptionPane.showMessageDialog(null, "Double: " + dato);
    }
}

// ---------------- FACTORIES ----------------
class ConsoleFactory implements IOFactory {
    @Override
    public Entrada crearEntrada() {
        return new ConsoleEntrada();
    }
    
    @Override
    public Salida crearSalida() {
        return new ConsoleSalida();
    }
}

class FrameFactory implements IOFactory {
    @Override
    public Entrada crearEntrada() {
        return new EntradaFrame();
    }
    
    @Override
    public Salida crearSalida() {
        return new FrameSalida();
    }
}

// ---------------- ADAPTERS ----------------
interface AdaptadorEntrada {
    String toString(String raw);
    boolean toBoolean(String raw);
    int toInt(String raw);
    float toFloat(String raw);
    double toDouble(String raw);
}

interface AdaptadorSalida {
    String formatString(Object source);
    String formatBoolean(Object source);
    String formatInt(Object source);
    String formatFloat(Object source);
    String formatDouble(Object source);
}

class AdaptadorEntradaConsola implements AdaptadorEntrada {
    @Override
    public String toString(String raw) { return raw; }
    
    @Override
    public boolean toBoolean(String raw) { 
        return Boolean.parseBoolean(raw); 
    }
    
    @Override
    public int toInt(String raw) { 
        return Integer.parseInt(raw); 
    }
    
    @Override
    public float toFloat(String raw) { 
        return Float.parseFloat(raw); 
    }
    
    @Override
    public double toDouble(String raw) { 
        return Double.parseDouble(raw); 
    }
}

class AdaptadorSalidaConsola implements AdaptadorSalida {
    @Override
    public String formatString(Object source) { 
        return String.valueOf(source); 
    }
    
    @Override
    public String formatBoolean(Object source) { 
        return String.valueOf(source); 
    }
    
    @Override
    public String formatInt(Object source) { 
        return String.valueOf(source); 
    }
    
    @Override
    public String formatFloat(Object source) { 
        return String.valueOf(source); 
    }
    
    @Override
    public String formatDouble(Object source) { 
        return String.valueOf(source); 
    }
}

// ---------------- CLIENTE ----------------
public class Cliente {
    private final Entrada entrada;
    private final Salida salida;
    private final AdaptadorEntrada adaptadorEntrada;
    private final AdaptadorSalida adaptadorSalida;

    // Mapa de conversiones permitidas
    private static final Map<String, String[]> CONVERSIONES_PERMITIDAS = new HashMap<>();
    
    static {
        CONVERSIONES_PERMITIDAS.put("string", new String[]{"string", "int", "float", "double", "boolean"});
        CONVERSIONES_PERMITIDAS.put("int", new String[]{"int", "string", "float", "double"});
        CONVERSIONES_PERMITIDAS.put("float", new String[]{"float", "string", "double"});
        CONVERSIONES_PERMITIDAS.put("double", new String[]{"double", "string", "float"});
        CONVERSIONES_PERMITIDAS.put("boolean", new String[]{"boolean", "string"});
    }

    public Cliente(IOFactory factory) {
        this.entrada = factory.crearEntrada();
        this.salida = factory.crearSalida();
        this.adaptadorEntrada = new AdaptadorEntradaConsola();
        this.adaptadorSalida = new AdaptadorSalidaConsola();
    }

    private boolean esConversionValida(String tipoEntrada, String tipoSalida) {
        if (!CONVERSIONES_PERMITIDAS.containsKey(tipoEntrada)) {
            return false;
        }
        
        for (String tipoPermitido : CONVERSIONES_PERMITIDAS.get(tipoEntrada)) {
            if (tipoPermitido.equals(tipoSalida)) {
                return true;
            }
        }
        
        return false;
    }

    public void ejecutar() {
        // Paso 1: preguntar tipo de dato de entrada
        String tipoEntrada = entrada.ingresarString(
            "¿Qué tipo de dato desea ingresar? (string/int/boolean/float/double)"
        );

        // Validar tipo de entrada
        if (!CONVERSIONES_PERMITIDAS.containsKey(tipoEntrada.toLowerCase())) {
            salida.mostrarString("Tipo de entrada no válido.");
            return;
        }

        // Capturamos SIEMPRE como String
        String raw = entrada.ingresarString("Ingrese el valor");

        Object valor = null;

        // Paso 2: usamos el AdaptadorEntrada para convertir al tipo correcto
        try {
            valor = switch (tipoEntrada.toLowerCase()) {
                case "string" -> adaptadorEntrada.toString(raw);
                case "int" -> adaptadorEntrada.toInt(raw);
                case "boolean" -> adaptadorEntrada.toBoolean(raw);
                case "float" -> adaptadorEntrada.toFloat(raw);
                case "double" -> adaptadorEntrada.toDouble(raw);
                default -> null;
            };
        } catch (NumberFormatException e) {
            salida.mostrarString("Error: El valor ingresado no es un " + tipoEntrada + " válido.");
            return;
        }

        // Paso 3: preguntar tipo de salida
        String tipoSalida = entrada.ingresarString(
            "¿En qué tipo de dato desea ver el valor? (string/int/boolean/float/double)"
        );

        // Validar conversión
        if (!esConversionValida(tipoEntrada.toLowerCase(), tipoSalida.toLowerCase())) {
            salida.mostrarString("Error: No se puede convertir de " + tipoEntrada + " a " + tipoSalida);
            return;
        }

        // Paso 4: convertir con AdaptadorSalida y mostrar
        try {
            switch (tipoSalida.toLowerCase()) {
                case "string" -> salida.mostrarString(adaptadorSalida.formatString(valor));
                case "int" -> salida.mostrarInt(Integer.parseInt(adaptadorSalida.formatInt(valor)));
                case "boolean" -> salida.mostrarBoolean(Boolean.parseBoolean(adaptadorSalida.formatBoolean(valor)));
                case "float" -> salida.mostrarFloat(Float.parseFloat(adaptadorSalida.formatFloat(valor)));
                case "double" -> salida.mostrarDouble(Double.parseDouble(adaptadorSalida.formatDouble(valor)));
                default -> salida.mostrarString("Tipo de salida no válido.");
            }
        } catch (NumberFormatException e) {
            salida.mostrarString("Error: No se pudo convertir el valor al tipo solicitado.");
        }
    }

    public static void main(String[] args) {
        // Elegir la implementación: Consola o Frame
        String choice = JOptionPane.showInputDialog(
            "Seleccione el modo de entrada/salida:\n1. Consola\n2. Frame (JOptionPane)"
        );

        IOFactory factory;
        switch (choice) {
            case "1" -> factory = new ConsoleFactory();
            case "2" -> factory = new FrameFactory();
            default -> {
                System.out.println("Opción no válida. Saliendo...");
                return;
            }
        }

        Cliente cliente = new Cliente(factory);
        cliente.ejecutar();
    }   
}
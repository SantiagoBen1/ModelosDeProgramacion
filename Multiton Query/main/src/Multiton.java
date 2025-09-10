import java.util.HashMap;
import java.util.Map;

public class Multiton {
    // Mapa estático para almacenar las instancias únicas
    private static Map<String, Multiton> instances = new HashMap<>();

    // Clave única de esta instancia
    private String key;

    // Constructor privado para prevenir instanciación directa
    private Multiton(String key) {
        this.key = key;
        System.out.println("Instancia Multiton creada con clave: " + key);
    }
    
    // Método estático para obtener la instancia correspondiente a la clave
    public static Multiton getInstance(String key) {
        // Sincronizado para thread safety
        synchronized (instances) {
            // Si la instancia con la clave dada no existe, crearla
            if (!instances.containsKey(key)) {
                instances.put(key, new Multiton(key));
            }
            // Devolver la instancia correspondiente a la clave
            return instances.get(key);
        }
    }

    // Método para mostrar la clave de la instancia
    public String getKey() {
        return key;
    }

    // Método para mostrar información de la instancia
    public void showInfo() {
        System.out.println("Instancia Multiton con clave: " + key);
    }
}
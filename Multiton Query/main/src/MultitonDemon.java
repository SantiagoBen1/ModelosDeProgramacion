// Clase de prueba para demostrar el funcionamiento
public class MultitonDemon {
    public static void main(String[] args) {
        System.out.println("=== Demostración del patrón Multiton ===");

        // Obtenemos instancias con diferentes claves
        Multiton instance1 = Multiton.getInstance("DB_CONNECTION");
        Multiton instance2 = Multiton.getInstance("CACHE_MANAGER");
        Multiton instance3 = Multiton.getInstance("DB_CONNECTION"); // Debería devolver la misma instancia que instance1

        // Mostramos información de las instancias
        instance1.showInfo();
        instance2.showInfo();
        instance3.showInfo();

        // Verificamos si son la misma instancia
        System.out.println("\n=== Verificación de instancias ===");
        System.out.println("instance1 y instance3 son la misma instancia: " + (instance1 == instance2));
        System.out.println("instance1 y instance3 son la misma instancia: " + (instance1 == instance3));
        System.out.println("instance2 y instance3 son la misma instancia: " + (instance2 == instance3));

        //Probamos con otra clave
        System.out.println("\n=== Otra instancia ===");
        Multiton instance4 = Multiton.getInstance("LOGGER");
        instance4.showInfo();

        // Mostramos el número total de instancias creadas
        System.out.println("""
                Número total de instancias creadas: DB_ CONNECTION, CACHE_MANAGER, LOGGER
                """);
    }
}

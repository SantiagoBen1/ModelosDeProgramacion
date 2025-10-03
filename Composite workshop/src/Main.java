// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Selección de I/O por usuario (consola o web stub)
        Scanner sc = new Scanner(System.in);
        System.out.println("Seleccione display: 1) Consola  2) Web (simulado)");
        String opt = sc.nextLine().trim();
        TransporteDisplay display = "2".equals(opt) ? new WebDisplay() : new ConsoleDisplay();

        // Factories
        TransportFactory avionFactory = new AvionFactory();
        TransportFactory barcoFactory = new BarcoFactory();

        // Crear algunos transportes usando factories (internamente usan Builders)
        Transporte a1 = avionFactory.crearTransporte("A320", "AirCorp", 180, 6100.0, display);
        Transporte b1 = barcoFactory.crearTransporte("Mariner", "SeaWorks", 50, 2000.0, display);

        // Crear una flota (Composite) y agregar elementos
        Flota flotaPrincipal = new Flota.Builder()
                .modelo("Flota Principal")
                .fabricante("OperatorInc")
                .capacidadPasajeros(0)
                .autonomia(0.0)
                .display(display)
                .build();

        flotaPrincipal.agregar(a1);
        flotaPrincipal.agregar(b1);

        // Mostrar la flota
        System.out.println("== Flota original ==");
        flotaPrincipal.mostrarInformacion();

        // Prototype: clonar la flota
        Transporte flotaClon = flotaPrincipal.cloneTransport();
        System.out.println("\n== Flota clonada ==");
        flotaClon.mostrarInformacion();

        // Demostrar clonación de un solo elemento
        Transporte avionClonado = a1.cloneTransport();
        System.out.println("\n== Avion clonado ==");
        avionClonado.mostrarInformacion();

        sc.close();
    }
}

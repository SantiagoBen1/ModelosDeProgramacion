import model.MapData;
import model.POI;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Punto de entrada de la aplicación de planificación de rutas.
 * Demuestra el uso del patrón Strategy alternando diferentes estrategias de cálculo
 * (auto, a pie, transporte público, bicicleta y turismo) para un mismo par de puntos.
 */
public class App {
    /**
     * Método principal que configura datos de ejemplo, cambia la estrategia de planificación
     * y muestra por consola los resultados de cada ruta calculada.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        MapData map = new MapData();
        Point start = new Point(-0.1807, -78.4678); // Ej: Quito
        Point end = new Point(-0.2100, -78.5000);

        Preferences prefs = new Preferences();
        prefs.setAvoidTolls(true);
        prefs.setScenic(false);
        prefs.setMaxTransfers(2);
        prefs.setMaxWalkingKm(2.5);
        prefs.addMustVisit(new POI("Plaza Central", new Point(-0.2200, -78.5100)));

        RoutePlanner planner = new RoutePlanner(new CarRouteStrategy());
        print("Auto", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new WalkingRouteStrategy());
        print("A pie", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new TransitRouteStrategy());
        print("Transporte público", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new CyclingRouteStrategy());
        prefs.setScenic(true);
        print("Bicicleta", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new TouristAttractionsRouteStrategy());
        print("Turismo", planner.planRoute(map, start, end, prefs));
    }

    /**
     * Imprime un resumen legible de una ruta en consola, incluyendo título, datos
     * generales y los pasos de navegación.
     *
     * @param title título o etiqueta de la ruta (p. ej., "Auto")
     * @param route ruta a imprimir; no debe ser null
     */
    private static void print(String title, Route route) {
        System.out.println("=== " + title + " ===");
        System.out.println(route);
        route.getSteps().forEach(s -> System.out.println(" - " + s));
        System.out.println();
    }
}

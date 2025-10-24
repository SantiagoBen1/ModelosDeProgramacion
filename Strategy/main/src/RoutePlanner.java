import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Contexto del patrón Strategy que delega el cálculo de rutas a una implementación de {@link RouteStrategy}.
 * Permite cambiar la estrategia en tiempo de ejecución.
 */
public class RoutePlanner {
    private RouteStrategy strategy;

    /**
     * Crea un planificador con una estrategia inicial.
     *
     * @param strategy estrategia concreta a utilizar; no debe ser null
     */
    public RoutePlanner(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Establece o cambia la estrategia de cálculo de rutas.
     *
     * @param strategy nueva estrategia; puede ser null, pero entonces {@link #planRoute} lanzará excepción
     */
    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Planifica una ruta delegando en la estrategia actual.
     *
     * @param map datos del mapa
     * @param start punto de origen
     * @param end punto de destino
     * @param prefs preferencias del usuario
     * @return ruta calculada por la estrategia
     * @throws IllegalStateException si no hay estrategia establecida
     */
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        if (strategy == null) {
            throw new IllegalStateException("No hay estrategia seleccionada");
        }
        return strategy.planRoute(map, start, end, prefs);
    }
}

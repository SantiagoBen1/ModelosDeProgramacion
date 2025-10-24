import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Interfaz Strategy: define el algoritmo de planificación de rutas.
 */
public interface RouteStrategy {
    /**
     * Calcula una ruta entre dos puntos, usando datos del mapa y preferencias.
     * Las implementaciones pueden aplicar diferentes heurísticas y fuentes de datos.
     *
     * @param map datos del mapa requeridos para el cálculo (capas, grafos, etc.)
     * @param start punto de origen
     * @param end punto de destino
     * @param prefs preferencias del usuario que condicionan el algoritmo
     * @return una {@link Route} con distancia, duración y pasos estimados
     */
    Route planRoute(MapData map, Point start, Point end, Preferences prefs);
}

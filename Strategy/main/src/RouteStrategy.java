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
     */
    Route planRoute(MapData map, Point start, Point end, Preferences prefs);
}

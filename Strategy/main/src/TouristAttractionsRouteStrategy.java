import java.util.ArrayList;
import java.util.List;
import model.MapData;
import model.POI;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Estrategia que planifica un trayecto pasando por puntos de interés (POI) marcados como
 * "imprescindibles" en las preferencias del usuario, añadiendo tiempo por parada.
 */
public class TouristAttractionsRouteStrategy implements RouteStrategy {
    /**
     * Construye una ruta que visita en orden los POIs definidos en {@code prefs.getMustVisit()},
     * comenzando en {@code start} y finalizando en {@code end}. Añade una penalización de tiempo
     * por cada visita para simular paradas.
     *
     * @param map datos del mapa (no utilizados en este stub)
     * @param start punto inicial
     * @param end punto final
     * @param prefs preferencias que incluyen la lista de POIs por visitar
     * @return ruta con distancia acumulada y pasos de visita a los POIs
     */
    @Override
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        double distance = 0.0;
        List<String> steps = new ArrayList<>();
        Point current = start;
        for (POI poi : prefs.getMustVisit()) {
            distance += haversineKm(current, poi.getLocation());
            steps.add("Visitar " + poi.getName());
            current = poi.getLocation();
        }
        distance += haversineKm(current, end);
        double speedKmh = 18.0; // ritmo pausado
        double durationMin = (distance / speedKmh) * 60.0 + prefs.getMustVisit().size() * 15.0; // 15min por parada
        steps.add("Llegar a destino final");
        return new Route(distance, durationMin, steps);
    }

    /**
     * Distancia en kilómetros usando Haversine entre dos coordenadas.
     *
     * @param a punto actual
     * @param b siguiente punto o destino
     * @return distancia aproximada en kilómetros
     */
    private static double haversineKm(Point a, Point b) {
        double R = 6371.0; // km
        double dLat = Math.toRadians(b.getLat() - a.getLat());
        double dLng = Math.toRadians(b.getLng() - a.getLng());
        double s = Math.sin(dLat/2)*Math.sin(dLat/2) + Math.cos(Math.toRadians(a.getLat()))*Math.cos(Math.toRadians(b.getLat()))*Math.sin(dLng/2)*Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(s), Math.sqrt(1-s));
        return R * c;
    }
}

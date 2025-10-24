import java.util.List;
import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Estrategia que estima rutas a pie, aplicando atajos peatonales y una penalización
 * de tiempo si la distancia supera la preferencia de caminata máxima.
 */
public class WalkingRouteStrategy implements RouteStrategy {
    /**
     * Calcula una ruta peatonal entre dos puntos con una velocidad promedio.
     * Si la distancia excede {@code prefs.getMaxWalkingKm()}, se aplica una penalización por fatiga.
     *
     * @param map datos del mapa (no se usan en este ejemplo)
     * @param start punto de salida
     * @param end punto de llegada
     * @param prefs preferencias del usuario relacionadas con caminata
     * @return ruta peatonal estimada con una lista de pasos simples
     */
    @Override
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        double distance = haversineKm(start, end) * 0.9; // atajos peatonales
        double speedKmh = 5.0; // caminando
        double durationMin = (distance / speedKmh) * 60.0;
        if (distance > Math.max(1.0, prefs.getMaxWalkingKm())) {
            durationMin *= 1.2; // penalización por fatiga si supera preferencia
        }
        return new Route(distance, durationMin, List.of(
            "Caminar desde " + start,
            "Seguir senda peatonal",
            "Llegar a " + end
        ));
    }

    /**
     * Calcula distancia aproximada entre dos puntos con Haversine.
     *
     * @param a origen
     * @param b destino
     * @return distancia en kilómetros
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

import java.util.ArrayList;
import java.util.List;
import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/**
 * Estrategia que estima un trayecto usando transporte público, con posibles transbordos
 * y tramos de acceso/salida a pie. Aplica penalización por número de transbordos.
 */
public class TransitRouteStrategy implements RouteStrategy {
    /**
     * Calcula la ruta en transporte público entre dos puntos, estimando distancia total,
     * número de transbordos y duración basada en una velocidad promedio.
     *
     * @param map datos del mapa (no utilizados en este stub)
     * @param start punto de origen
     * @param end punto de destino
     * @param prefs preferencias; se usa {@code getMaxTransfers()} para limitar transbordos
     * @return ruta con pasos que incluyen caminar, tomar líneas y transbordos
     */
    @Override
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        double distance = haversineKm(start, end) * 1.1; // desvíos por líneas
        int transfers = Math.max(0, (int)Math.round(distance / 5.0) - 1);
        transfers = Math.min(transfers, Math.max(0, prefs.getMaxTransfers()));
        double baseSpeed = 25.0; // km/h
        double durationMin = (distance / baseSpeed) * 60.0 + transfers * 5; // penalizar transbordos

        List<String> steps = new ArrayList<>();
        steps.add("Caminar a la estación inicial");
        steps.add("Tomar línea 1 por " + Math.max(1, (int)distance/2) + " paradas");
        if (transfers > 0) steps.add("Transbordar " + transfers + " vez/veces");
        steps.add("Bajar y caminar a destino");

        return new Route(distance, durationMin, steps);
    }

    /**
     * Distancia aproximada entre dos puntos geográficos con Haversine.
     *
     * @param a inicio del tramo
     * @param b fin del tramo
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

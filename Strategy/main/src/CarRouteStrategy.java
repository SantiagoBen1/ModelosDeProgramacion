import java.util.List;
import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

interface RouteStrategy {
    Route planRoute(MapData map, Point start, Point end, Preferences prefs);
}

/** Estrategia por carretera/auto. */
public class CarRouteStrategy implements RouteStrategy {
    @Override
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        double distance = haversineKm(start, end);
        // Supongamos velocidad promedio 40 km/h, peajes evitan desvíos si avoidTolls
        double speedKmh = 40.0 - (prefs.isAvoidTolls() ? 5.0 : 0.0);
        double durationMin = (distance / Math.max(10, speedKmh)) * 60.0;
        return new Route(distance, durationMin, List.of(
            "Salir en coche desde " + start,
            (prefs.isAvoidTolls()? "Evitar peajes." : "Permitir peajes si acortan."),
            "Conducir hasta destino " + end
        ));
    }

    private static double haversineKm(Point a, Point b) {
        double R = 6371.0; // km
        double dLat = Math.toRadians(b.getLat() - a.getLat());
        double dLng = Math.toRadians(b.getLng() - a.getLng());
        double s = Math.sin(dLat/2)*Math.sin(dLat/2) + Math.cos(Math.toRadians(a.getLat()))*Math.cos(Math.toRadians(b.getLat()))*Math.sin(dLng/2)*Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(s), Math.sqrt(1-s));
        return R * c;
    }
}

import java.util.List;
import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/** Estrategia para ciclistas. */
public class CyclingRouteStrategy implements RouteStrategy {
    @Override
    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        double distance = haversineKm(start, end) * 0.95; // atajos por ciclovías
        double speedKmh = prefs.isScenic() ? 15.0 : 20.0; // paseo escénico es más lento
        double durationMin = (distance / speedKmh) * 60.0;
        return new Route(distance, durationMin, List.of(
            "Iniciar pedaleo desde " + start,
            (prefs.isScenic()? "Tomar ruta escénica" : "Tomar ciclovía directa"),
            "Arribar a " + end
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

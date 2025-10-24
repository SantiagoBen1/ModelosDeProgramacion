import java.util.ArrayList;
import java.util.List;
import model.MapData;
import model.POI;
import model.Point;
import model.Preferences;
import model.Route;

/** Estrategia que pasa por atracciones turísticas indicadas en preferencias. */
public class TouristAttractionsRouteStrategy implements RouteStrategy {
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

    private static double haversineKm(Point a, Point b) {
        double R = 6371.0; // km
        double dLat = Math.toRadians(b.getLat() - a.getLat());
        double dLng = Math.toRadians(b.getLng() - a.getLng());
        double s = Math.sin(dLat/2)*Math.sin(dLat/2) + Math.cos(Math.toRadians(a.getLat()))*Math.cos(Math.toRadians(b.getLat()))*Math.sin(dLng/2)*Math.sin(dLng/2);
        double c = 2 * Math.atan2(Math.sqrt(s), Math.sqrt(1-s));
        return R * c;
    }
}

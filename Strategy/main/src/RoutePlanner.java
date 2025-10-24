import model.MapData;
import model.Point;
import model.Preferences;
import model.Route;

/** Contexto que usa una RouteStrategy para calcular rutas. */
public class RoutePlanner {
    private RouteStrategy strategy;

    public RoutePlanner(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(RouteStrategy strategy) {
        this.strategy = strategy;
    }

    public Route planRoute(MapData map, Point start, Point end, Preferences prefs) {
        if (strategy == null) {
            throw new IllegalStateException("No hay estrategia seleccionada");
        }
        return strategy.planRoute(map, start, end, prefs);
    }
}

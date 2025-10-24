import model.MapData;
import model.POI;
import model.Point;
import model.Preferences;
import model.Route;

public class App {
    public static void main(String[] args) {
        MapData map = new MapData();
        Point start = new Point(-0.1807, -78.4678); // Ej: Quito
        Point end = new Point(-0.2100, -78.5000);

        Preferences prefs = new Preferences();
        prefs.setAvoidTolls(true);
        prefs.setScenic(false);
        prefs.setMaxTransfers(2);
        prefs.setMaxWalkingKm(2.5);
        prefs.addMustVisit(new POI("Plaza Central", new Point(-0.2200, -78.5100)));

        RoutePlanner planner = new RoutePlanner(new CarRouteStrategy());
        print("Auto", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new WalkingRouteStrategy());
        print("A pie", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new TransitRouteStrategy());
        print("Transporte público", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new CyclingRouteStrategy());
        prefs.setScenic(true);
        print("Bicicleta", planner.planRoute(map, start, end, prefs));

        planner.setStrategy(new TouristAttractionsRouteStrategy());
        print("Turismo", planner.planRoute(map, start, end, prefs));
    }

    private static void print(String title, Route route) {
        System.out.println("=== " + title + " ===");
        System.out.println(route);
        route.getSteps().forEach(s -> System.out.println(" - " + s));
        System.out.println();
    }
}

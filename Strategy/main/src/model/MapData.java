package model;

/**
 * Datos del mapa necesarios por las estrategias. Aquí es un stub.
 */
public class MapData {
    private final Graph graph = new Graph();
    private final TrafficData trafficLayer = new TrafficData();
    private final POIs poiLayer = new POIs();

    public Graph getGraph() { return graph; }
    public TrafficData getTrafficLayer() { return trafficLayer; }
    public POIs getPoiLayer() { return poiLayer; }

    // Stubs mínimos
    public static class Graph { }
    public static class TrafficData { }
    public static class POIs { }
}

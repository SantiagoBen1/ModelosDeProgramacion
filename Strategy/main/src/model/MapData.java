package model;

/**
 * Datos del mapa necesarios por las estrategias. Aquí es un stub simplificado
 * que representa capas típicas (grafo vial, tráfico y puntos de interés).
 */
public class MapData {
    private final Graph graph = new Graph();
    private final TrafficData trafficLayer = new TrafficData();
    private final POIs poiLayer = new POIs();

    /**
     * Obtiene la capa de grafo vial o de conectividad.
     *
     * @return instancia de {@link Graph}
     */
    public Graph getGraph() { return graph; }
    /**
     * Obtiene la capa de tráfico (condiciones en tiempo real o históricas).
     *
     * @return instancia de {@link TrafficData}
     */
    public TrafficData getTrafficLayer() { return trafficLayer; }
    /**
     * Obtiene la capa de puntos de interés.
     *
     * @return instancia de colección de POIs
     */
    public POIs getPoiLayer() { return poiLayer; }

    // Stubs mínimos
    /** Representa una red de nodos/aristas para enrutamiento. */
    public static class Graph { }
    /** Representa información de tráfico. */
    public static class TrafficData { }
    /** Representa un contenedor de puntos de interés. */
    public static class POIs { }
}

package model;

/**
 * Punto de interés (POI) con nombre y ubicación geográfica.
 */
public class POI {
    private final String name;
    private final Point location;

    /**
     * Crea un POI con nombre y coordenadas.
     *
     * @param name nombre del punto de interés
     * @param location ubicación representada como {@link Point}
     */
    public POI(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    /**
     * Nombre legible del POI.
     *
     * @return nombre del punto de interés
     */
    public String getName() { return name; }
    /**
     * Coordenadas del POI.
     *
     * @return ubicación como {@link Point}
     */
    public Point getLocation() { return location; }
}

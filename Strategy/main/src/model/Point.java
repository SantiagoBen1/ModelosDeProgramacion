package model;

/**
 * Punto geográfico definido por latitud y longitud en grados decimales.
 */
public class Point {
    private final double lat;
    private final double lng;

    /**
     * Crea un punto con latitud y longitud.
     *
     * @param lat latitud en grados decimales
     * @param lng longitud en grados decimales
     */
    public Point(double lat, double lng) {
        this.lat = lat;
        this.lng = lng;
    }

    /**
     * Devuelve la latitud del punto.
     *
     * @return latitud en grados decimales
     */
    public double getLat() { return lat; }
    /**
     * Devuelve la longitud del punto.
     *
     * @return longitud en grados decimales
     */
    public double getLng() { return lng; }

    @Override
    /**
     * Representación corta en texto del punto.
     *
     * @return cadena con el formato "(lat, lng)"
     */
    public String toString() {
        return "(" + lat + ", " + lng + ")";
    }
}

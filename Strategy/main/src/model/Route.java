package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Resultado de un cálculo de ruta. Contiene distancia, duración estimada y
 * una lista de descripciones de pasos para navegación.
 */
public class Route {
    private final double distanceKm;
    private final double durationMin;
    private final List<String> steps; // Simplificación: descripciones de pasos

    /**
     * Crea un resultado de ruta.
     *
     * @param distanceKm distancia total aproximada en kilómetros
     * @param durationMin duración estimada en minutos
     * @param steps lista de pasos descriptivos; si es null se usa una lista vacía
     */
    public Route(double distanceKm, double durationMin, List<String> steps) {
        this.distanceKm = distanceKm;
        this.durationMin = durationMin;
        this.steps = new ArrayList<>(steps == null ? List.of() : steps);
    }

    /**
     * Distancia total estimada de la ruta.
     *
     * @return kilómetros totales
     */
    public double getDistanceKm() { return distanceKm; }
    /**
     * Duración total estimada de la ruta.
     *
     * @return minutos totales
     */
    public double getDurationMin() { return durationMin; }
    /**
     * Pasos de navegación en forma de descripciones de texto.
     *
     * @return lista no modificable de pasos
     */
    public List<String> getSteps() { return Collections.unmodifiableList(steps); }

    @Override
    /**
     * Resumen corto de la ruta con distancia, tiempo y número de pasos.
     *
     * @return representación textual compacta de la ruta
     */
    public String toString() {
        return String.format("Route{dist=%.1fkm, time=%.0fmin, steps=%d}", distanceKm, durationMin, steps.size());
    }
}

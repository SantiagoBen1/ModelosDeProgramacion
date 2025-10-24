package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Route {
    private final double distanceKm;
    private final double durationMin;
    private final List<String> steps; // Simplificación: descripciones de pasos

    public Route(double distanceKm, double durationMin, List<String> steps) {
        this.distanceKm = distanceKm;
        this.durationMin = durationMin;
        this.steps = new ArrayList<>(steps == null ? List.of() : steps);
    }

    public double getDistanceKm() { return distanceKm; }
    public double getDurationMin() { return durationMin; }
    public List<String> getSteps() { return Collections.unmodifiableList(steps); }

    @Override
    public String toString() {
        return String.format("Route{dist=%.1fkm, time=%.0fmin, steps=%d}", distanceKm, durationMin, steps.size());
    }
}

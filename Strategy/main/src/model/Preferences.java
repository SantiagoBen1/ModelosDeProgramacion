package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Preferencias del usuario que influyen en la planificación de rutas.
 * Incluye banderas (evitar peajes, ruta escénica), límites (transbordos, caminata)
 * y una lista de puntos de interés obligatorios.
 */
public class Preferences {
    private boolean avoidTolls;
    private boolean scenic;
    private int maxTransfers;
    private double maxWalkingKm;
    private final List<POI> mustVisit = new ArrayList<>();

    /**
     * Indica si se deben evitar peajes.
     *
     * @return true si se desea evitar peajes
     */
    public boolean isAvoidTolls() { return avoidTolls; }
    /**
     * Configura la preferencia de evitar peajes.
     *
     * @param avoidTolls true para evitar peajes
     */
    public void setAvoidTolls(boolean avoidTolls) { this.avoidTolls = avoidTolls; }

    /**
     * Indica si se priorizan rutas escénicas.
     *
     * @return true si se prefiere una ruta más paisajística
     */
    public boolean isScenic() { return scenic; }
    /**
     * Configura la preferencia de ruta escénica.
     *
     * @param scenic true para preferir rutas escénicas
     */
    public void setScenic(boolean scenic) { this.scenic = scenic; }

    /**
     * Número máximo de transbordos permitidos en transporte público.
     *
     * @return máximo de transbordos
     */
    public int getMaxTransfers() { return maxTransfers; }
    /**
     * Define el límite de transbordos permitidos.
     *
     * @param maxTransfers cantidad máxima de transbordos
     */
    public void setMaxTransfers(int maxTransfers) { this.maxTransfers = maxTransfers; }

    /**
     * Distancia máxima preferida para caminar en kilómetros.
     *
     * @return kilómetros máximos a pie
     */
    public double getMaxWalkingKm() { return maxWalkingKm; }
    /**
     * Establece la distancia máxima sugerida para caminar.
     *
     * @param maxWalkingKm límite en kilómetros
     */
    public void setMaxWalkingKm(double maxWalkingKm) { this.maxWalkingKm = maxWalkingKm; }

    /**
     * Lista inmutable de puntos de interés que se desea visitar necesariamente.
     *
     * @return lista no modificable de POIs
     */
    public List<POI> getMustVisit() { return Collections.unmodifiableList(mustVisit); }
    /**
     * Agrega un punto de interés a la lista de visitas obligatorias.
     *
     * @param poi punto de interés a agregar; se ignora si es null
     */
    public void addMustVisit(POI poi) { if (poi != null) mustVisit.add(poi); }
}

package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Preferences {
    private boolean avoidTolls;
    private boolean scenic;
    private int maxTransfers;
    private double maxWalkingKm;
    private List<POI> mustVisit = new ArrayList<>();

    public boolean isAvoidTolls() { return avoidTolls; }
    public void setAvoidTolls(boolean avoidTolls) { this.avoidTolls = avoidTolls; }

    public boolean isScenic() { return scenic; }
    public void setScenic(boolean scenic) { this.scenic = scenic; }

    public int getMaxTransfers() { return maxTransfers; }
    public void setMaxTransfers(int maxTransfers) { this.maxTransfers = maxTransfers; }

    public double getMaxWalkingKm() { return maxWalkingKm; }
    public void setMaxWalkingKm(double maxWalkingKm) { this.maxWalkingKm = maxWalkingKm; }

    public List<POI> getMustVisit() { return Collections.unmodifiableList(mustVisit); }
    public void addMustVisit(POI poi) { if (poi != null) mustVisit.add(poi); }
}

package model;

public class POI {
    private final String name;
    private final Point location;

    public POI(String name, Point location) {
        this.name = name;
        this.location = location;
    }

    public String getName() { return name; }
    public Point getLocation() { return location; }
}

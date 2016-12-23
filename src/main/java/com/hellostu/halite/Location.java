package com.hellostu.halite;

public class Location {
    public int x, y;

    public Location(int x_, int y_) {
        x = x_;
        y = y_;
    }
    public Location(Location l) {
        x = l.x;
        y = l.y;
    }

    public double distanceFromLocation(Location location) {
        double dX = (double)(location.x - x);
        double dY = (double)(location.y - y);
        return dX + dY;
    }
}

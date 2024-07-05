package org.simulation.entity;

import org.simulation.map.Coordinates;

public abstract class Entity {
    private Coordinates coordinates;



    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

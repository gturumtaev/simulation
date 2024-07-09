package org.simulation.entity;

import org.simulation.map.Coordinates;

public abstract class Entity {
    protected Coordinates coordinates;

    public Entity() {

    }

    public Entity(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }
}

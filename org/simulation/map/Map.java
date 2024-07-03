package org.simulation.map;

import org.simulation.entity.Entity;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final int width;
    private final int length;
    private final List<Entity> entities = new ArrayList<>();

    public Map(int width, int length) {
        this.width = width;
        this.length = length;
    }

    public Map() {
        this.width = 30;
        this.length = 30;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public void addEntity(Entity entity) {
        entities.add(entity);
    }

    public void removeEntity(Entity entity) {
        entities.remove(entity);
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public boolean isEmptyCell(Coordinates coordinates) {
        return coordinates.getEntity() == null;
    }

    public Class<? extends Entity> getTypeEntity(Coordinates coordinates) {
        if (coordinates.getEntity() == null) return null;
        return coordinates.getEntity().getClass();
    }

    public boolean isInsideMapBorder(Coordinates coordinates) {
        return coordinates.getX() >= 0 && coordinates.getX() < length && coordinates.getY() >= 0 && coordinates.getY() < width;
    }

}

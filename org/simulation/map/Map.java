package org.simulation.map;

import org.simulation.entity.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Map {
    private final int width;
    private final int length;
    private Coordinates[][] map;
    private final HashMap<Entity, Coordinates> entities = new HashMap<>();

    public Map(int width, int length) {
        this.width = width;
        this.length = length;
        map = new Coordinates[length][width];
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < width; j++) {
                map[i][j] = new Coordinates(i, j);
            }
        }
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
        Coordinates c = entity.getCoordinates();
        map[c.getX()][c.getY()].setEntity(entity);
        entities.put(entity, c);
    }

    public void removeEntity(Coordinates coordinates) {
        Entity entity = coordinates.getEntity();
        if (entity != null) {
            map[coordinates.getX()][coordinates.getY()].setEntity(null);
            entities.remove(entity);
        }
    }

    public void moveEntities(Entity entity, Coordinates newCoordinates) {
        Coordinates oldCoordinates = entity.getCoordinates();
        map[oldCoordinates.getX()][oldCoordinates.getY()].setEntity(null);
        entity.setCoordinates(newCoordinates);
        map[newCoordinates.getX()][newCoordinates.getY()].setEntity(entity);
        entities.put(entity, newCoordinates);
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
    public Coordinates getCellByCoordinates(int x, int y) {
        if (x >= 0 && x < length && y >= 0 && y < width) return map[x][y];
        return null;
    }

    public HashMap<Coordinates, Entity> getMapCoordinatesEntitiesOfType (Class<? extends Entity> entityType) {
        HashMap<Coordinates, Entity> result = new HashMap<>();
        for (HashMap.Entry<Entity, Coordinates> entry : entities.entrySet()) {
            if (entry.getKey().getClass() == entityType) {
                result.put(entry.getValue(), entry.getKey());
            }
        }
        return result;
    }

}

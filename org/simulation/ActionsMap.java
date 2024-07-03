package org.simulation;

import org.simulation.entity.Creature;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;
import org.simulation.entity.Herbivore;
import org.simulation.map.Map;

public class ActionsMap {
    private Map map;

    public Grass findClosestGrass(Creature creature) {
        Grass closestGrass = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entity entity : map.getEntities()) {
            if (entity instanceof Grass) {
                Grass grass = (Grass) entity;
                int distance = Math.abs(creature.getCoordinates().getX() - grass.getCoordinates().getX())
                        + Math.abs(creature.getCoordinates().getY() - grass.getCoordinates().getY());
                if (distance <= minDistance) minDistance = distance;
                closestGrass = grass;
            }
        }
        return closestGrass;
    }

    public Herbivore findClosestHerbivore(Creature creature) {
        Herbivore closestHerbivore = null;
        int minDistance = Integer.MAX_VALUE;
        for (Entity entity : map.getEntities()) {
            if (entity instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) entity;
                int distance = Math.abs(creature.getCoordinates().getX() - herbivore.getCoordinates().getX())
                        + Math.abs(creature.getCoordinates().getY() - herbivore.getCoordinates().getY());
                if (distance <= minDistance) {
                    minDistance = distance;
                    closestHerbivore = herbivore;
                }
            }

        }
        return closestHerbivore;
    }

    public void eatGrass(Creature creature) {
        for (int i = 0; i < map.getEntities().size(); i++) {
            if ((Grass) map.getEntities().get(i) instanceof Grass &&
                    map.getEntities().get(i).getCoordinates().getX() == creature.getCoordinates().getX() &&
                    map.getEntities().get(i).getCoordinates().getY() == creature.getCoordinates().getY()) {
                map.getEntities().remove(i);
                break;
            }
        }
    }

    public boolean isCellFree(int x, int y) {
        for (Entity entity : map.getEntities()) {
            if (entity.getCoordinates().getX() == x && entity.getCoordinates().getY() == y) {
                return false;
            }
        }
        return true;
    }




}

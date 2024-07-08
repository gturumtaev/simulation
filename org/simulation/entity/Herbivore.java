package org.simulation.entity;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;
import org.simulation.pathfinding.PathFinderAStar;
import org.simulation.pathfinding.PathNode;

import java.util.List;

public class Herbivore extends Creature{


    public Herbivore(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    @Override
    public void makeMove(Map map) {
        PathFinderAStar pathFinder = new PathFinderAStar(Grass.class);
        PathNode goal = pathFinder.smellVictim(map, coordinates);
        if (goal != null) {
            List<PathNode> path = pathFinder.getPathToGoal(new PathNode(coordinates), goal, map);
            if (path != null && !path.isEmpty()) {
                Coordinates nextCell = path.get(1).getCoordinates();
                if (map.isEmptyCell(nextCell)) map.moveEntities(this, nextCell);
                else if (nextCell.getEntity() instanceof Grass) {
                    map.removeEntity(nextCell);
                    map.moveEntities(this, nextCell);
                }
            }
        }
    }


}

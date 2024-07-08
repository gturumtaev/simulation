package org.simulation.entity;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;
import org.simulation.pathfinding.PathFinderAStar;
import org.simulation.pathfinding.PathNode;

import java.util.List;

public class Predator extends Creature{

    private int attackPower = 5;

    public Predator(Coordinates coordinates, int speed, int hp) {
        super(coordinates, speed, hp);
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    @Override
    public void makeMove(Map map) {
        PathFinderAStar pathFinder = new PathFinderAStar(Herbivore.class);
        PathNode goal = pathFinder.smellVictim(map, coordinates);
        if (goal != null) {
            List<PathNode> path = pathFinder.getPathToGoal(new PathNode(coordinates), goal, map);
            Coordinates nextCell = path.get(1).getCoordinates();
            if (nextCell.getEntity() == null) map.moveEntities(this, nextCell);
            else if (nextCell.getEntity() instanceof Herbivore) {
                Herbivore herbivore = (Herbivore) nextCell.getEntity();
                herbivore.setHp(herbivore.getHp() - attackPower);
                if (herbivore.getHp() <= 0) {
                    map.removeEntity(nextCell);
                    map.moveEntities(this, nextCell);
                }
            }
        }
    }
}

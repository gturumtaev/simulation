package org.simulation.entity;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;

public abstract class Creature extends Entity{
    private int speed;
    private int hp;





    public abstract void makeMove(Map map);

}

package org.simulation.entity;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;

public abstract class Creature extends Entity{
    private int speed;
    private int hp;

    public Creature(Coordinates coordinates, int speed, int hp) {
        super(coordinates);
        this.speed = speed;
        this.hp = hp;
    }

    public abstract void makeMove(Map map);

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }
}

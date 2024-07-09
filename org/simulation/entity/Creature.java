package org.simulation.entity;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;

public abstract class Creature extends Entity{
    private int speed;
    private int hp;

    public Creature() {

    }

    public Creature(Coordinates coordinates) {
        super(coordinates);
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

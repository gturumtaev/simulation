package org.simulation.pathfinding;

import org.simulation.map.Coordinates;

import java.util.Objects;

public class PathNode {
    private int x;
    private int y;
    private int pathCost;
    private Coordinates coordinates;

    public PathNode(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PathNode(Coordinates coordinates) {
        this.coordinates = coordinates;
    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPathCost() {
        return pathCost;
    }

    public void setPathCost(int pathCost) {
        this.pathCost = pathCost;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PathNode)) return false;
        PathNode pathNode = (PathNode) o;
        return x == pathNode.x && y == pathNode.y && pathCost == pathNode.pathCost;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y, pathCost);
    }

    @Override
    public String toString() {
        return "PathNode{" +
                "x=" + x +
                ", y=" + y +
                ", pathCost=" + pathCost +
                '}';
    }
}

package org.simulation.pathfinding;

import org.simulation.entity.Entity;
import org.simulation.map.Coordinates;
import org.simulation.map.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class PathFinderAStar {

    private static final int PATH_COST_DIRECT = 10;
    private static final int PATH_COST_DIAGONAL = 14;
    private final Class<? extends Entity> victim;

    public PathFinderAStar(Class<? extends Entity> victim) {
        this.victim = victim;
    }

    public ListForPathFinding<PathNode> getPahToGoal(PathNode start, PathNode goal, Map map) {
        PriorityQueue<ListForPathFinding<PathNode>> openPathNode = new PriorityQueue<>();
        HashMap<PathNode, Integer> costFromStart = new HashMap<>();
        costFromStart.put(start, 0);

        ListForPathFinding<PathNode> tmp = new ListForPathFinding<>();
        tmp.add(start);
        openPathNode.add(tmp);

        while (!openPathNode.isEmpty()) {
            ListForPathFinding<PathNode> currentPath = openPathNode.poll();
            if (currentPath == null || currentPath.isEmpty()) return null;
            PathNode currentNode = currentPath.get(currentPath.size() - 1);
            if (currentNode.equals(goal)) return currentPath;

            for (Coordinates coordinate : findNeighbors(currentNode.getCoordinates())) {
                PathNode nextNode = new PathNode(coordinate);
                int newCost = costFromStart.get(currentNode) + costMovingToNeighborPathNode(nextNode, currentNode);
                if ((map.isEmptyCell(nextNode.getCoordinates()) || map.getTypeEntity(nextNode.getCoordinates()) == victim) &&
                        map.isInsideMapBorder(nextNode.getCoordinates())) {
                    if (!costFromStart.containsKey(nextNode) || newCost < costFromStart.get(nextNode)) {
                        costFromStart.put(nextNode, newCost);
                        nextNode.setPathCost(newCost + heuristic(nextNode.getCoordinates(), goal.getCoordinates()));
                    }
                }
            }
        }
        return null;
    }

    public static List<Coordinates> findNeighbors(Coordinates current) {
        List<Coordinates> neighbors = new ArrayList<>();
        int x = current.getX();
        int y = current.getY();
        for (int i = x - 1; i < x + 2; i++) {
            for (int j = y - 1; j < y + 2; j++) {
                if ((i != x || j != y ) && (i >= 0) && (j >= 0)) neighbors.add(new Coordinates(i, j));
            }
        }
        return neighbors;
    }

    private int costMovingToNeighborPathNode(PathNode next, PathNode current) {
        return next.getX() != current.getX() && next.getY() != current.getY() ? PATH_COST_DIAGONAL : PATH_COST_DIRECT;
    }

    private int heuristic(Coordinates current, Coordinates next) {
        return (Math.abs(current.getX() - next.getX()) + Math.abs(current.getY()) - next.getY()) * PATH_COST_DIRECT;
    }
}

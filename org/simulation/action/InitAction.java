package org.simulation.action;

import org.simulation.map.Coordinates;
import org.simulation.map.Map;
import org.simulation.entity.Entity;
import org.simulation.entity.Grass;
import org.simulation.entity.Ground;
import org.simulation.entity.Herbivore;
import org.simulation.entity.Predator;
import org.simulation.entity.Rock;
import org.simulation.entity.Tree;

import java.util.HashMap;
import java.util.Random;

public class InitAction extends Action{
    private Map map;

//    public Map initMap() {
//        map = new Map();
//        HashMap<Integer, Integer> pool = createObjectPoolForMap(map);
//        for (int i = 0; i < pool.size(); i++) {
//            int amountOfEntity = pool.get(i);
//
//            for (int j = 0; j < amountOfEntity; j++) {
//                if (i == 0) {
//                    Ground ground = new Ground();
//                    initCoordinateToEntity(ground);
//                    map.addEntity(ground);
//                }
//                if (i == 1) {
//                    Grass grass = new Grass();
//                    initCoordinateToEntity(grass);
//                    map.addEntity(grass);
//                }
//                if (i == 2) {
//                    Herbivore herbivore = new Herbivore();
//                    initCoordinateToEntity(herbivore);
//                    map.addEntity(herbivore);
//                }
//                if (i == 3) {
//                    Predator predator = new Predator();
//                    initCoordinateToEntity(predator);
//                    map.addEntity(predator);
//                }
//                if (i == 4) {
//                    Tree tree = new Tree();
//                    initCoordinateToEntity(tree);
//                    map.addEntity(tree);
//                }
//                if (i == 5) {
//                    Rock rock = new Rock();
//                    initCoordinateToEntity(rock);
//                    map.addEntity(rock);
//                }
//            }
//        }
//        return map;
//
//    }

    private HashMap<Integer, Integer> createObjectPoolForMap(Map map) {
        HashMap<Integer, Integer> objectPool = new HashMap<>();
        int area = map.getWidth() * map.getLength();

        int amountOfGround = area / 2;
        objectPool.put(0, amountOfGround);

        int amountOfGrass = area / 5;
        objectPool.put(1, amountOfGrass);

        int amountOfHerbivore = amountOfGrass / 2;
        objectPool.put(2, amountOfHerbivore);

        int amountOfPredator = amountOfHerbivore / 2;
        objectPool.put(3, amountOfPredator);

        int amountOfTrees = amountOfGrass / 2;
        objectPool.put(4, amountOfTrees);

        int amountOfRocks = amountOfTrees / 2;
        objectPool.put(5, amountOfRocks);

        return objectPool;
    }

//    private <T extends Entity> void initCoordinateToEntity(T entity) {
//        Coordinates coordinates = null;
//        do {
//            coordinates = generateRandomCoordinateToEntity();
//        } while (!isCellFree(coordinates));
//        entity.setCoordinates(coordinates);
//    }

//    private boolean isCellFree(Coordinates coordinates) {
//        for (Entity entity : map.getEntities()) {
//            if (entity.getCoordinates().getX() == coordinates.getX() && entity.getCoordinates().getY() == coordinates.getY()) {
//                return false;
//            }
//        }
//        return true;
//    }

    private Coordinates generateRandomCoordinateToEntity() {
        Random random = new Random();
        int randomX = random.nextInt(map.getLength());
        int randomY = random.nextInt(map.getWidth());
        return new Coordinates(randomX, randomY);
    }

}

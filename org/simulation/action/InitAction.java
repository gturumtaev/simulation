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

    public Map initMap() {
        map = new Map();
        HashMap<Integer, Integer> pool = createObjectPoolForMap(map);
        for (int i = 0; i < pool.size(); i++) {
            int amountOfEntity = pool.get(i);

            for (int j = 0; j < amountOfEntity; j++) {
                if (i == 0) {
                    Grass grass = new Grass();
                    initCoordinateToEntity(grass);
                    map.addEntity(grass);
                }
                if (i == 1) {
                    Herbivore herbivore = new Herbivore();
                    initCoordinateToEntity(herbivore);
                    map.addEntity(herbivore);
                }
                if (i == 2) {
                    Predator predator = new Predator();
                    initCoordinateToEntity(predator);
                    map.addEntity(predator);
                }
                if (i == 3) {
                    Tree tree = new Tree();
                    initCoordinateToEntity(tree);
                    map.addEntity(tree);
                }
                if (i == 4) {
                    Rock rock = new Rock();
                    initCoordinateToEntity(rock);
                    map.addEntity(rock);
                }
            }
        }

        for (int i = 0; i < map.getLength(); i++) {
            for (int j = 0; j < map.getWidth(); j++) {
                if (map.getCellByCoordinates(i, j).getEntity() == null) map.addEntity(new Ground(map.getCellByCoordinates(i, j)));
            }
        }
        return map;

    }

    private HashMap<Integer, Integer> createObjectPoolForMap(Map map) {
        HashMap<Integer, Integer> objectPool = new HashMap<>();
        int area = map.getWidth() * map.getLength();

        int amountOfGrass = area / 5;
        objectPool.put(0, amountOfGrass);

        int amountOfHerbivore = amountOfGrass / 2;
        objectPool.put(1, amountOfHerbivore);

        int amountOfPredator = amountOfHerbivore / 2;
        objectPool.put(2, amountOfPredator);

        int amountOfTrees = amountOfGrass / 2;
        objectPool.put(3, amountOfTrees);

        int amountOfRocks = amountOfTrees / 2;
        objectPool.put(4, amountOfRocks);

        return objectPool;
    }

    private <T extends Entity> void initCoordinateToEntity(T entity) {
        Coordinates coordinates = null;
        do {
            coordinates = generateRandomCoordinateToEntity();
        } while (!map.isEmptyCell(coordinates));
        map.moveEntities(entity, coordinates);
    }

    private Coordinates generateRandomCoordinateToEntity() {
        Random random = new Random();
        int randomX = random.nextInt(map.getLength());
        int randomY = random.nextInt(map.getWidth());
        return new Coordinates(randomX, randomY);
    }

}

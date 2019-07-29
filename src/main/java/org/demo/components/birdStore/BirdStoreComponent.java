package org.demo.components.birdStore;


import lombok.Getter;
import org.demo.exceptions.forBirdStore.BirdAlreadyExistException;
import org.demo.exceptions.forBirdStore.BirdNotFoundException;
import org.demo.exceptions.forBirdStore.BirdsInAreaNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Отнаследоваться от AbstractBirdStore.
 * <p>
 * Реализовать паттерн Singleton.
 */

@Component
public class BirdStoreComponent extends AbstractBirdStore {
    private static ConcurrentHashMap<String, Bird> birdStore = new ConcurrentHashMap<>();

    Logger logger = LoggerFactory.getLogger(BirdStoreComponent.class);
    @Getter
    private static final BirdStoreComponent instance = new BirdStoreComponent();

    @Override
    public void addBird(Bird bird) throws BirdAlreadyExistException {
        if (birdStore.containsKey(bird.getName())) {
            logger.info("Birds if alredy exist");
            throw new BirdAlreadyExistException(bird.getName());
        } else {
            birdStore.put(bird.getName(), bird);
            logger.info("Bird WAS created");

        }
    }

    @Override
    public boolean removeBird(String name) throws BirdNotFoundException {
        if (!birdStore.containsKey(name)) {
            logger.info("not find Bird");
            throw new BirdNotFoundException(name);
        } else {
            birdStore.remove(name);
            logger.info("Bird was removed");
            return false;
        }
    }

    @Override
    public Bird searchByName(String nameToSearch) throws BirdNotFoundException {
        Bird bird = birdStore.get(nameToSearch);
        if (bird == null) {
            logger.info("There no birds with this name!");
            throw new BirdNotFoundException(nameToSearch);
        } else return bird;
    }

    @Override
    public List searchByLivingArea(String livingAreaToFind) throws BirdsInAreaNotFoundException {
        List listOfBirdsByArea = new ArrayList();
        birdStore.entrySet().forEach(a -> {
            if (a.getValue().getLocation().getName().equals(listOfBirdsByArea)) {
                listOfBirdsByArea.add(a.getValue());
            }
        });
        return listOfBirdsByArea;
    }

    @Override
    public Bird updateBird(String name, String newName) throws BirdNotFoundException {
        Bird bird = birdStore.get(name);
        if (bird==null){
            logger.info("There no birds with this name!");
            throw new BirdNotFoundException(name);
        }
        else {
            birdStore.get(name).setName(newName);
        }
        return bird;
    }
}

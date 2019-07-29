package org.demo.components.birdStore;

import org.demo.exceptions.forBirdStore.BirdAlreadyExistException;
import org.demo.exceptions.forBirdStore.BirdNotFoundException;
import org.demo.exceptions.forBirdStore.BirdsInAreaNotFoundException;

import java.util.List;

public abstract class AbstractBirdStore {

    public abstract void addBird(Bird bird) throws BirdAlreadyExistException;

    public abstract boolean removeBird(String name) throws BirdNotFoundException;

    public abstract Bird searchByName(String nameToSearch) throws BirdNotFoundException;

    public abstract List searchByLivingArea(String livingAreaToFind) throws BirdsInAreaNotFoundException;

    public abstract Bird updateBird(String name, String newName) throws BirdNotFoundException;
}

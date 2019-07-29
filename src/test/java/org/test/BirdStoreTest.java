package org.test;

import org.demo.components.birdStore.Bird;
import org.demo.components.birdStore.BirdStoreComponent;
import org.demo.exceptions.forBirdStore.BirdAlreadyExistException;
import org.demo.exceptions.forBirdStore.BirdNotFoundException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BirdStoreTest {
    private BirdStoreComponent storeComponent;
    private Bird bird;
    private Bird falseBird;

    @Before
    public void beforeTest(){
        storeComponent= BirdStoreComponent.getInstance();
        bird = new Bird("one","one");
    }

    @Test
    public void addBird() throws BirdAlreadyExistException,BirdNotFoundException{
        storeComponent.addBird(bird);
        Assert.assertEquals(bird,storeComponent.searchByName(bird.getName()));
    }
    @Test(expected = BirdAlreadyExistException.class)
    public void addBirdAlredyExistException() throws BirdAlreadyExistException {
        storeComponent.addBird(bird);
        storeComponent.addBird(bird);
    }

    @Test
    public void deleteBird()throws Exception{
        storeComponent.removeBird(bird.getName());
    }
    @Test(expected = BirdAlreadyExistException.class)
    public void updateBird() throws BirdAlreadyExistException, BirdNotFoundException {
        String name = "one";
        String newName = "Second";
        storeComponent.addBird(bird);
        Bird expected = new Bird(newName,"test");
        storeComponent.addBird(expected);
        Assert.assertEquals(storeComponent.searchByName(name).getName(),name);
        Assert.assertEquals(expected,storeComponent.searchByName(newName));
        storeComponent.updateBird(bird.getName(),newName);
        Assert.assertEquals(bird.getName(),expected.getName());

    }

}

package org.demo.exceptions.forBirdStore;

import lombok.Getter;

public class BirdAlreadyExistException extends Exception{
    @Getter
    private String birdName;
    public BirdAlreadyExistException(String birdName){
        this.birdName=birdName;
    }
}

package org.demo.exceptions.forBirdStore;


import lombok.Getter;

public class BirdNotFoundException extends Exception{
    @Getter
    private String birdName;

    public BirdNotFoundException(String birdName) {
            this.birdName = birdName;
        }
}

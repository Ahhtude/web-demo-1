package org.demo.components.birdStore;

import lombok.Data;

@Data
public class Location {
    private String id;
    private String name;
    private static int idCounter;

    public Location(String name) {
        this.name = name;
        ++idCounter;
        this.id= ""+ idCounter;
    }

}

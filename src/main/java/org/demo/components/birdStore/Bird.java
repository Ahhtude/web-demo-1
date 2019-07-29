package org.demo.components.birdStore;


import lombok.Data;

@Data
public class Bird {

    private String id;

    private int idCounter;

    private String name;

    private Double size;

    private Location location;

    public Bird(String name, String location) {
        this.name = name;
        this.location = new Location(location);
        ++idCounter;
        this.id=""+idCounter;
    }

    public Bird() {
        ++idCounter;
    }
}

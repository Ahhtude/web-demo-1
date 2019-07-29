package org.demo.exceptions.forBirdStore;

import lombok.Getter;

public class BirdsInAreaNotFoundException extends Exception {
    @Getter
    private String area;

    public BirdsInAreaNotFoundException(String area)
    {
        this.area = area;
    }
}

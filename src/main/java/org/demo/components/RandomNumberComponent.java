package org.demo.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.logging.Logger;

@Component
public class RandomNumberComponent {

    private final DataStore ds;

    @Autowired
    public RandomNumberComponent(DataStore ds) {
        this.ds = ds;
    }

    public int getRandom(int seed) {
        System.out.println("Data from datastore " + ds.getDataFromStorage());
        Random r = new Random(seed);
        return r.nextInt();
    }
}

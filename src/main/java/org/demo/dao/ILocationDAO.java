package org.demo.dao;

import org.demo.components.birdStore.Location;

public interface ILocationDAO {
    boolean exists(String locatonId);
    Location add (Location location);
    boolean delete(String location);

    /**
     * @param location
     * @return null if delete;
     */

}

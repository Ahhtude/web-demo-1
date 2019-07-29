package org.demo.dao;

import org.demo.components.birdStore.Bird;

import java.util.List;

public interface IBirdDAO {
    Bird add (Bird bird);
    boolean delete (String id);
    List<Bird> findBylocation(String location);
    Bird update(Bird bird);
}

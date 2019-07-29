package org.demo.dao.impl;

import org.demo.dao.IBirdDAO;
import org.demo.dao.ILocationDAO;
import org.demo.components.birdStore.Bird;
import org.demo.components.birdStore.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;



@Component
public class BirdDAUimpl implements IBirdDAO {

    private JdbcTemplate template;


    @Autowired
    @Qualifier("DataBaseFirstJDBC")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }
    @Autowired
    private ILocationDAO locationDAO;


    @Override
    public Bird add(Bird bird) {
        Location location = bird.getLocation();
        if (bird.getLocation()!=null
            && locationDAO.exists(bird.getLocation().getId())){
            locationDAO.add(bird.getLocation());
        }
        template.update("INSERT BIRDS(ID,NAME,SIZE,LOCATION_ID)\n"+
        "VALUES (?,?,?,?)",bird.getId(),bird.getName(),bird.getSize()
                ,location == null ? null : location.getId());

        return bird;
    }

    @Override
    public boolean delete(String id) {
    int rows = template.update("DELETE FROM BIRDS WHERE ID = ?",id);
        if (rows == 1 ){
            return true;
        }
throw new RuntimeException(String.format("Bird with id %s not exist",id));
    }

    @Override
    public List<Bird> findBylocation(String location) {
        return null;
    }

    @Override
    public Bird update(Bird bird) {
        return null;
    }
}

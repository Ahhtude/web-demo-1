package org.demo.dao.impl;

import org.demo.dao.ILocationDAO;
import org.demo.components.birdStore.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;


@Component
public class LocationDAOimpl implements ILocationDAO {

    private JdbcTemplate template;


    @Autowired
    @Qualifier("DataBaseFirstJDBC")
    public void setTemplate(JdbcTemplate template) {
        this.template = template;
    }

    @Override
    public boolean exists(String locatonId) {
        return template.queryForObject("SELECT COUNT (*) FROM LOCATIONS WHERE ID=?",
                Boolean.class, locatonId);
    }

    @Override
    public Location add(Location location) {
        int rows = template.update("INSERT INTO LOCATIONS(ID,NAME)+\n" +
                "VALUES (?, ?)", location.getId(), location.getName());
        if (rows == 1) {
            return location;
        }
        throw new RuntimeException("Something went wrong");
    }

    @Override
    public boolean delete(String location) {
        int rows = template.update("DELETE FROM LOCATION WHERE ID=?", location);
        if (rows == 1) {
            return true;
        }
        throw new RuntimeException(String.format("Location %s not found", location));
    }
}

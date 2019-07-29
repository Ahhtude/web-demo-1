package org.demo.controllers;

import org.demo.components.birdStore.Bird;
import org.demo.components.birdStore.BirdStoreComponent;
import org.demo.exceptions.forBirdStore.BirdNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;



@Controller
public class BirdController {
    private Logger logger = LoggerFactory.getLogger(BirdController.class);

    public BirdController() {
        logger.info("Bird controller was created");
    }

    @Autowired
    private BirdStoreComponent birdStore;

    @RequestMapping(value = "/add-bird",method = RequestMethod.PUT)
    @ResponseBody
    public String addBird(String name, String livingAre) throws Exception {
        Bird bird = new Bird(name, livingAre);
        birdStore.addBird(bird);
        logger.info("Bird was added +\n");
        return bird.getName();
    }


    @RequestMapping(value = "/delete-bird",method = RequestMethod.DELETE)
    @ResponseBody
    public String deleteBird(String name) throws BirdNotFoundException{
        birdStore.removeBird(name);
        logger.info("Bird was deleted - ");
        return "Bird was deleted";
    }

    @RequestMapping(value = "/update-bird", method = RequestMethod.POST)
    @ResponseBody
    public String updateBird(String name, String newName) throws BirdNotFoundException{
    Bird bird = birdStore.updateBird(name,newName);
    return bird.toString() + "was renamed";
    }

    @RequestMapping(value = "/find-bird", method = RequestMethod.GET)
    @ResponseBody
    public String findBird(String name) throws BirdNotFoundException {
        Bird bird = birdStore.searchByName(name);
        logger.info("Find bird... \n");
        if (bird != null)
            return bird.toString();
        return "Bird was find";
    }
}

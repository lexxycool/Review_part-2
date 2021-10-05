package com.techelevator.puppyApi.controller;

import com.techelevator.puppyApi.data.PuppyDAO;
import com.techelevator.puppyApi.model.Puppy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class PuppyController {

    @Autowired
    PuppyDAO dao;

    @RequestMapping(path="/test", method= RequestMethod.GET)
    public String test() {
        return "POTATO";
    }

    @RequestMapping(path="/all-puppies", method = RequestMethod.GET)
	public List<Puppy> getAllPuppies() {
        List<Puppy> allPuppies = dao.getPuppies();
        return allPuppies;
    }

    @RequestMapping(path="/puppy/{id}", method = RequestMethod.GET)
    public Puppy getPuppy(@PathVariable int id) {

        Puppy puppy = dao.getPuppy(id);
        return puppy;
    }

    @RequestMapping(path="/add-puppy", method = RequestMethod.POST)
    public void addPuppy(@RequestBody @Valid Puppy puppy) {
        dao.savePuppy(puppy);
    }

}

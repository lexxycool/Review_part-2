package com.techelevator.tenmo.controller;

import com.techelevator.tenmo.dao.PuppyDAO;
import com.techelevator.tenmo.model.Puppy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/all-puppies")
@PreAuthorize("isAuthenticated()")
public class ApplicationController {

    @Autowired
    PuppyDAO dao;

    @RequestMapping(path="", method = RequestMethod.GET)
    public List<Puppy> getAllPuppies() {
        List<Puppy> allPuppies = dao.getPuppies();
        return allPuppies;
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public Puppy getAPuppy(@PathVariable int id) {
        Puppy puppy = dao.getPuppy(id);
        return puppy;
    }

}

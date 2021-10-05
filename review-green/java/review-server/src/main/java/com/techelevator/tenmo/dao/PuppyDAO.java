package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Puppy;

import java.util.List;

public interface PuppyDAO {

    public List<Puppy> getPuppies();

    public Puppy getPuppy(int id);

    public void savePuppy(Puppy puppyToSave);

    public void removePuppy(int id);

    public void editPuppy(Puppy puppyToSave);
}
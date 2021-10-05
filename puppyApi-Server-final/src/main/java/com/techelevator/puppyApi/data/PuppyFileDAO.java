package com.techelevator.puppyApi.data;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import com.techelevator.puppyApi.model.Puppy;


public class PuppyFileDAO implements PuppyDAO {

	@Override
	public List<Puppy> getPuppies() {
		// TODO Auto-generated method stub
		
		List<Puppy> puppyList = new ArrayList<Puppy>();
		
		try {
			File file = new ClassPathResource("data.txt").getFile();
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String line = scanner.nextLine();
				String [] lineArr  = line.split("\\,");
				
				int id = Integer.parseInt(lineArr[0]);
				String name = lineArr[1];
				int weight = Integer.parseInt(lineArr[2]);
				String gender = lineArr[3];
				boolean trained = lineArr[4].equals("true") ? true : false;
				
				Puppy puppy = new Puppy(id, name, weight, gender, trained);
				puppyList.add(puppy);
				
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return puppyList;
	}

	@Override
	public Puppy getPuppy(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removePuppy(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void editPuppy(Puppy puppyToSave) {
		// TODO Auto-generated method stub
		
	}

}

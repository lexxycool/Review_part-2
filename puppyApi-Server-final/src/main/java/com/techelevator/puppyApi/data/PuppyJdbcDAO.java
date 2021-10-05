package com.techelevator.puppyApi.data;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.techelevator.puppyApi.model.Puppy;

@Component
public class PuppyJdbcDAO implements PuppyDAO {
	
	
	private JdbcTemplate template;
	
	public PuppyJdbcDAO(DataSource datasource) {
		template = new JdbcTemplate(datasource);
	}

	@Override
	public List<Puppy> getPuppies() {
		// TODO Auto-generated method stub
		String sqlGetAllPuppies = "SELECT * FROM puppies";
		List<Puppy> puppyList = new ArrayList<Puppy>();
		SqlRowSet result = template.queryForRowSet(sqlGetAllPuppies);
		
		while(result.next()) {
			
			int id = result.getInt("id");
			String name = result.getString("name");
			int weight = result.getInt("weight");
			String gender = result.getString("gender");
			boolean paperTrained = result.getBoolean("paper_trained");
			
			Puppy puppy = new Puppy(id, name, weight, gender, paperTrained);
			puppyList.add(puppy);
			
		}
		
		return puppyList;
	}

	@Override
	public Puppy getPuppy(int id) {

		String sql = "SELECT * FROM puppies where id = ?";
		SqlRowSet result = template.queryForRowSet(sql, id);
		Puppy puppy = null;

		if (result.next()) {
			int id2 = result.getInt("id");
			String name = result.getString("name");
			int weight = result.getInt("weight");
			String gender = result.getString("gender");
			boolean paperTrained = result.getBoolean("paper_trained");

			puppy = new Puppy(id2, name, weight, gender, paperTrained);
		}

		return puppy;
	}

	@Override
	public void savePuppy(Puppy puppyToSave) {

		String name = puppyToSave.getName();
		int weight = puppyToSave.getWeight();
		String gender = puppyToSave.getGender();
		boolean paperTrained = puppyToSave.isPaperTrained();

		String sql = "INSERT INTO puppies(name, weight, gender,paper_trained) VALUES(?, ?, ?, ?)";
		template.update(sql, name, weight, gender, paperTrained);
	}

	@Override
	public void removePuppy(int id) {
		String sqlForRemove = "DELETE FROM puppies WHERE id=?";
		template.update(sqlForRemove, id);
	}

	/*
	 * Body:
	 * {
        "id": 1,
        "name": "Lady",
        "weight": 18,
        "gender": "Female",
        "paperTrained": true
    	}
	 * Note that the regardless of the data passed, only the weight and paper_trained can
	 * be changed. The id must be present in the puppyToSave object.
	 * */
	
	@Override
	public void editPuppy(Puppy puppyToSave) {
		String sqlUpdPuppy = "UPDATE puppies " + "SET weight = ? , paper_trained = ? WHERE id=?";
		template.update(sqlUpdPuppy, puppyToSave.getWeight(), puppyToSave.isPaperTrained(), puppyToSave.getId());
	}

}

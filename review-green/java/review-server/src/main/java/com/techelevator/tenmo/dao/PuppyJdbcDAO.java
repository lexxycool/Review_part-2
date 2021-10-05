package com.techelevator.tenmo.dao;

import com.techelevator.tenmo.model.Puppy;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.List;

@Component
public class PuppyJdbcDAO implements PuppyDAO {

    private JdbcTemplate template;

    public PuppyJdbcDAO(DataSource datasource) {
        template = new JdbcTemplate(datasource);
    }

    @Override
    public List<Puppy> getPuppies() {
        String sqlGetAllPuppies = "SELECT * FROM puppies";
        List<Puppy> puppyList = new ArrayList<Puppy>();
        SqlRowSet result = template.queryForRowSet(sqlGetAllPuppies);

        while (result.next()) {

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
        Puppy puppy = null;
        String sql = "select * from puppies where id = ?";
        SqlRowSet result = template.queryForRowSet(sql, id);
        if(result.next()) {
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

    }

    @Override
    public void editPuppy(Puppy puppyToSave) {

    }

    @Override
    public void removePuppy(int id) {

    }

}
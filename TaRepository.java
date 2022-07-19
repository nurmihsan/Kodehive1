package com.example.demo.repository.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.demo.model.TaModel;
import com.example.demo.repository.ITaRepository;

@Repository
public class TaRepository implements ITaRepository{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int insert(TaModel model) {
		var query = "insert into ta" + "(id, judul, nilai, tahun)" + "values (?,?,?,?)";
		return jdbc.update(query ,new Object[] { model.getId(), model.getJudul(), model.getNilai(), model.getTahun() });
	}

	@Override
	public List<TaModel> readAllData() {
		var query = "SELECT * FROM ta ";
		var result = jdbc.query(query, new BeanPropertyRowMapper<TaModel>(TaModel.class));
		return result;
	}

	@Override
	public List<TaModel> readCustom() {
		var query = "SELECT * FROM ta"
				+ "WHERE ? = ?";
		return null;
	}

	@Override
	public List<TaModel> getEqTahun(Integer tahun) {
		var query = "SELECT * FROM ta"
				+ " WHERE tahun = "+tahun;
		var result = jdbc.query(query, 
				new BeanPropertyRowMapper<TaModel>(TaModel.class)
				);
		return result;
	}

	@Override
	public List<TaModel> getGTTahun(Integer tahun) {
		var query = "SELECT * FROM ta"
				+ " WHERE tahun <= "+tahun;
		var result = jdbc.query(query, 
				new BeanPropertyRowMapper<TaModel>(TaModel.class)
				);
		return result;
	}

	@Override
	public int deleteById(int id) {
		var query = "DELETE FROM ta"
				+ " WHERE id = " + id;
		return jdbc.update(query);
	}

	@Override
	public int gantinilai(Integer id, Integer nilai) {
		var query = "UPDATE ta"
				+ " SET nilai = "+ nilai
				+ " WHERE id = "+id;
		return jdbc.update(query);
	}
	
}

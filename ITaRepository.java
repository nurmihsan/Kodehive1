package com.example.demo.repository;

import java.util.List;

import com.example.demo.model.TaModel;

public interface ITaRepository {

	int insert(TaModel model);

	List<TaModel> readAllData();
	
	List<TaModel> readCustom();
	
	List<TaModel> getEqTahun(Integer tahun);
	
	List<TaModel> getGTTahun(Integer tahun);

	int deleteById(int id);

	int gantinilai(Integer id, Integer nilai);
}
	


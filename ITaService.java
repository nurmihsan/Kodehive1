package com.example.demo.service;

import java.util.List;

import com.example.demo.model.TaModel;

public interface ITaService {
	
	int insert(TaModel model);
	
	public List<TaModel> readAllData();
	
	public int deleteById(int id);

	int gantiNilai(Integer id, Integer nilai);

	List<TaModel> getGTTahun(Integer tahun);

	List<TaModel> getEqTahun(Integer tahun);
}

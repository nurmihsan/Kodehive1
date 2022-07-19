package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.TaModel;
import com.example.demo.repository.ITaRepository;
import com.example.demo.repository.impl.TaRepository;
import com.example.demo.service.ITaService;

@Service
public class TaService implements ITaService {
	
	@Autowired
	ITaRepository TaRepository;
	
	@Override
	public int insert(TaModel model) {
			var result= TaRepository.insert(model);
			return result;
	}
		@Override
		public List<TaModel> readAllData() {
			var result = TaRepository.readAllData();
			System.out.println("select success");
			return result;
		}
		
		@Override
		public List<TaModel> getEqTahun(Integer tahun) {
			var result = TaRepository.getEqTahun(tahun);
			return result;
		}
		
		@Override
		public List<TaModel> getGTTahun(Integer tahun) {
			var result = TaRepository.getGTTahun(tahun);
			return result;
		}

		@Override
		public int gantiNilai(Integer id,Integer nilai) {
			return TaRepository.gantinilai(id, nilai);
		}
		
		@Override
		public int deleteById(int id) {
			return TaRepository.deleteById(id);
		}
	
}

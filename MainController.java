package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.TaModel;
import com.example.demo.service.ITaService;
import com.example.demo.service.impl.TaService;


@RestController
@RequestMapping("/api")
public class MainController {
	
	@Autowired
	ITaService TaService;
	
	@PostMapping("/insert")
	public String insert(@RequestBody TaModel model) {
		TaService.insert(model);
		return "sukses coy";
		
	}
	
	@GetMapping("/readall")
	public List<TaModel> getAllData(){
		return TaService.readAllData();
	}
	
	@GetMapping("geteqtahun")
	public List<TaModel> getEqTahun(@RequestParam Integer tahun){
		return TaService.getEqTahun(tahun);
	}
	
	@GetMapping("/getgttahun")
	public List<TaModel> getGTTahun(@RequestParam Integer tahun){
		return TaService.getGTTahun(tahun);
	}
	
	@GetMapping("deletebyid")
	public String deleteById(@RequestParam int id) {
		return "update success "+ TaService.deleteById(id);
	}
	
	@PutMapping("gantinilai")
	public String putNilai(@RequestParam int id, int nilai) {
		return "update success "+ TaService.gantiNilai(id, nilai);
	}
}

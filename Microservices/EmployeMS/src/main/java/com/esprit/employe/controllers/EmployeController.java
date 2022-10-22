package com.esprit.employe.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.employe.Services.IEmployeService;
import com.esprit.employe.entities.Employe;



@RestController
public class EmployeController {
	@Autowired
	IEmployeService ES;
	
	//http://localhost:8080/SpringMVC/servlet/allEmploye
	//@CrossOrigin(origins ="*")
	@GetMapping("/allEmploye")
	@ResponseBody
	public List<Employe> getEmploye(){
		List<Employe> l=ES.retrieveAllEmploye();
		return l;
	}
	
	@PostMapping("/addEmploye")
	@ResponseBody
	public Employe addAchat(@RequestBody Employe a) {
		return ES.addEmploye(a);
	}
	
	@PostMapping("/deleteEmploye")
	@ResponseBody
	public void deleteAchat(@RequestBody Employe a) {
		ES.deleteEmploye(a);
	}
	
	@GetMapping("/getEmploye/{id}")
	@ResponseBody
	public Optional<Employe> getUser(@PathVariable(value = "id")int id){
		Optional<Employe> a=ES.retrieveEmploye(id);
		return a;
	}
	
	@PostMapping("/updateEmploye")
	@ResponseBody
	public Employe updateAchat(@RequestBody Employe a) {
		return ES.updateEmploye(a);
	}
	
		
}

package com.esprit.coffee.controllers;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.coffee.Services.ICoffeeService;
import com.esprit.coffee.entities.Coffee;



@RestController
public class CoffeeController {
	@Autowired
	ICoffeeService achatService;
	
	//http://localhost:8080/SpringMVC/servlet/allCoffee
	//@CrossOrigin(origins ="*")
	@GetMapping("/allCoffee")
	@ResponseBody
	public List<Coffee> getCoffee(){
		List<Coffee> l=achatService.retrieveAllCoffee();
		return l;
	}
	
	@PostMapping("/addCoffee")
	@ResponseBody
	public Coffee addAchat(@RequestBody Coffee a) {
		return achatService.addCoffee(a);
	}
	
	@PostMapping("/deleteCoffee")
	@ResponseBody
	public void deleteAchat(@RequestBody Coffee a) {
		achatService.deleteCoffee(a);
	}
	
	@GetMapping("/getCoffee/{id}")
	@ResponseBody
	public Optional<Coffee> getUser(@PathVariable(value = "id")int id){
		Optional<Coffee> a=achatService.retrieveCoffee(id);
		return a;
	}
	
	@PostMapping("/updateCoffee")
	@ResponseBody
	public Coffee updateAchat(@RequestBody Coffee a) {
		return achatService.updateCoffee(a);
	}
	
		
}

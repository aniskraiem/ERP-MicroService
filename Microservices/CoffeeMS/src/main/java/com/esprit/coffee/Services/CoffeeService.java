package com.esprit.coffee.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.coffee.Repository.CoffeeRepository;
import com.esprit.coffee.entities.Coffee;



@Service
public class CoffeeService implements ICoffeeService {

	@Autowired
	CoffeeRepository ar;
	
	@Override
	public List<Coffee> retrieveAllCoffee() {
		List <Coffee> al =(List<Coffee>) ar.findAll();
		return al;
	}

	@Override
	public Coffee addCoffee(Coffee a) {
		return (Coffee) ar.save(a);
	}

	@Override
	public void deleteCoffee(Coffee a) {
		ar.deleteById(a.getId());
		
	}

	@Override
	public Coffee updateCoffee(Coffee a) {
		Coffee al = (Coffee) ar.save(a);
		return al;
	}

	@Override
	public Optional<Coffee> retrieveCoffee(int id) {
		Optional<Coffee> a=ar.findById(id);
		return a;
	}

}

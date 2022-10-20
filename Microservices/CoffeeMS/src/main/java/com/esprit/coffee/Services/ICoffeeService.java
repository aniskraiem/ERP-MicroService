package com.esprit.coffee.Services;
import java.util.List;
import java.util.Optional;

import com.esprit.coffee.entities.Coffee;



public interface ICoffeeService {
	List<Coffee> retrieveAllCoffee();
	Coffee addCoffee(Coffee a);
	void deleteCoffee(Coffee a);
	Coffee updateCoffee(Coffee a);
	Optional<Coffee> retrieveCoffee(int id);
}

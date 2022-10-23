package com.esprit.employe.Services;
import com.esprit.employe.entities.Employe;

import java.util.List;
import java.util.Optional;


public interface IEmployeService {
	List<Employe> retrieveAllEmploye();
	Employe addEmploye(Employe a);
	void deleteEmploye(Employe a);
	Employe updateEmploye(Employe a);
	Optional<Employe> retrieveEmploye(int id);
}

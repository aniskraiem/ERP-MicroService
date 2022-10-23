package com.esprit.employe.Services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.employe.entities.Employe;
import com.esprit.employe.Repository.EmployeRepository;
@Service
public class EmployeService implements IEmployeService {

	@Autowired
    EmployeRepository ar;
	
	@Override
	public List<Employe> retrieveAllEmploye() {
		List <Employe> al =(List<Employe>) ar.findAll();
		return al;
	}

	@Override
	public Employe addEmploye(Employe a) {
		return (Employe) ar.save(a);
	}

	@Override
	public void deleteEmploye(Employe a) {
		ar.deleteById(a.getId());
		
	}

	@Override
	public Employe updateEmploye(Employe a) {
		Employe al = (Employe) ar.save(a);
		return al;
	}

	@Override
	public Optional<Employe> retrieveEmploye(int id) {
		Optional<Employe> a=ar.findById(id);
		return a;
	}

}

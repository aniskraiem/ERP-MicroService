package com.esprit.employe.Repository;

import com.esprit.employe.entities.Employe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeRepository extends CrudRepository<Employe,Integer> {

}

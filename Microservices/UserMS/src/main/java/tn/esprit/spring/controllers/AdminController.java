package tn.esprit.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.userService;

@Slf4j
@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	userService userService;
	
	@GetMapping("/getUsers")
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PostMapping("/addRoleToUser")
	@ResponseBody
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
		if(form.getRoleLibelle().toString().equals("ROLE_SUPER_ADMIN") || form.getRoleLibelle().toString().equals("ADMIN")) {
			return ResponseEntity.status(401).body("Vous n'avez pas le droit d'ajouter un Super Admin");
		}
		else {
			userService.addRoleToUser(form.getUserName(),form.getRoleLibelle());
		}
		return ResponseEntity.ok().build();
	}
}



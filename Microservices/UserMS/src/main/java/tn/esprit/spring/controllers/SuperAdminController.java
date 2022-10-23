package tn.esprit.spring.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Role;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.userService;

@Slf4j
@RestController
@RequestMapping("/superAdmin")
public class SuperAdminController {
	@Autowired
	userService userService;
	
	@GetMapping("/getUsers")
	@ResponseBody
	public ResponseEntity<List<User>> getAllUsers(){
		return ResponseEntity.ok().body(userService.getUsers());
	}
	
	@PostMapping("/addUser")
	@ResponseBody
	public ResponseEntity<?> addUser(@RequestBody User user){
		boolean exist = false;
		List<User> l = userService.getUsers();
		for(int i=0 ; i < l.size(); i++) {
			if(l.get(i).getUserName().equals(user.getUserName())) {
				exist = true;
			}
		}
		if(exist) {
			return ResponseEntity.status(403).body("le username utilisé existe déja");
		}
		else {
			URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/addUser").toUriString());
			return ResponseEntity.created(uri).body(userService.addUser(user));
		}
	}
	
	@PutMapping("/updateUser")
	@ResponseBody
	public ResponseEntity<?> updateUser(@RequestBody User user){
		User user2 = userService.getUserById(user.getId());
		user.setPassword(user2.getPassword());
		System.out.print(user2.getRoles());
		user.setRoles(user2.getRoles());
		
		return ResponseEntity.ok().body(userService.updateUser(user));
	}

	@DeleteMapping("/deleteUser/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteUser(@PathVariable int id){
		userService.deleteUser(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/addRole")
	@ResponseBody
	public ResponseEntity<Role> addUser(@RequestBody Role role){
		URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/user/addRole").toUriString());
		return ResponseEntity.created(uri).body(userService.addRole(role));
	}
	
	@DeleteMapping("/deleteRole/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteRole(@PathVariable int id){
		userService.deleteRole(id);
		return ResponseEntity.ok().build();
	}
	
	@PostMapping("/addRoleToUser")
	@ResponseBody
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form){
		userService.addRoleToUser(form.getUserName(),form.getRoleLibelle());
		return ResponseEntity.ok().build();
	}
	
}
@Data
class RoleToUserForm{
	private String userName;
	private String roleLibelle;
}
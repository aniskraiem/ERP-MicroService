package tn.esprit.spring;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import tn.esprit.spring.entites.Role;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.userService;

@SpringBootApplication
@EnableEurekaClient
public class MicroServiceUsersApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicroServiceUsersApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(userService userService) {
		return args -> {
			boolean exist = false,exist2 = false;
			List<User> ListUsers = userService.getUsers();
			List<Role> ListRoles = userService.getRoles();
			for(int i=0 ; i < ListUsers.size(); i++) {
				if(ListUsers.get(i).getUserName().equals("superadmin1")) {
					exist = true;
				}
			}	
			for(int j=0 ; j < ListRoles.size(); j++) {
				if(ListRoles.get(j).getLibelle().equals("ROLE_SUPER_ADMIN")) {
					exist2 = true;
				}
			}
			if(exist == false) {
				User user = new User(1, "superadmin1", "superadmin1@superadmin1", "superadmin1", "superadmin1", "superadmin1", null);
				if(exist2 == false) {
					Role role = new Role(1, "ROLE_SUPER_ADMIN");				
					userService.addRole(role);				
				}
				userService.addUser(user);
				userService.addRoleToUser(user.getUserName(),"ROLE_SUPER_ADMIN");				
				
			}
		};
	}
	
	

}

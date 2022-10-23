package tn.esprit.spring.services;

import java.util.List;
import java.util.Set;

import tn.esprit.spring.entites.Role;
import tn.esprit.spring.entites.User;

public interface userService {
	User addUser(User user);
	User updateUser(User user);
	void deleteUser(int id);
	Role addRole(Role role);
	List<Role> getRoles();
	void deleteRole(int id);
	void addRoleToUser(String userName, String roleLibelle);
	User getUser(String userName);
	User getUserById(int id);
	List<User> getUsers();
	
}

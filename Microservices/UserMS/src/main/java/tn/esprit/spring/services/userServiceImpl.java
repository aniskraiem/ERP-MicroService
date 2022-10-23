package tn.esprit.spring.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Role;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.repositories.RoleRepository;
import tn.esprit.spring.repositories.UserRepository;

@Slf4j
@Service
public class userServiceImpl implements userService, UserDetailsService{
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	
	@Override
	public User addUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
	@Override
	public User updateUser(User user) {
		if (userRepository.existsById(user.getId()))
		{
			return userRepository.save(user);			
		}
		return null;
	}
	@Override
	public void deleteUser(int id) {
		userRepository.deleteById(id);
		
	}
	
	@Override
	public Role addRole(Role role) {
		return roleRepository.save(role);
	}
	@Override
	public List<Role> getRoles() {
		List l = new ArrayList<>();
		roleRepository.findAll().forEach(l::add);
		return l;
	}
	@Override
	public void deleteRole(int id) {
		roleRepository.deleteById(id);
		
	}
	@Override
	public void addRoleToUser(String userName, String roleLibelle) {
		User user = userRepository.findByUserName(userName);
		Role role = roleRepository.findByLibelle(roleLibelle);
		user.getRoles().add(role);
		userRepository.save(user);
	}
	@Override
	public User getUser(String userName) {
		return userRepository.findByUserName(userName);
	}
	@Override
	public List<User> getUsers() {
		List l = new ArrayList<>();
		userRepository.findAll().forEach(l::add);
		return l;
	}

	@Override
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		if(user == null) {
			log.info("User not foud in the database");
			throw new UsernameNotFoundException("User not foud in the database");
		}else {
			log.info("User foud in the database");
		}
		List<SimpleGrantedAuthority> authorities = new ArrayList<>();
		user.getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getLibelle()));
			});
		return new org.springframework.security.core.userdetails.User(user.getUserName(),user.getPassword(),authorities);
	}
	
	

	
	
	
	

}

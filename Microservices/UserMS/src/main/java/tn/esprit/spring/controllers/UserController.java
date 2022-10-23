package tn.esprit.spring.controllers;

import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import tn.esprit.spring.entites.Role;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.userService;

@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	userService userService;
	

	@GetMapping("/getUser/{id}")
	@ResponseBody
	public ResponseEntity<User> getUser(@PathVariable int id){
		return ResponseEntity.ok().body(userService.getUserById(id));
	}
	
	@GetMapping("/refreshToken")
	@ResponseBody
	public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String authorizationHeader = request.getHeader("Authorization");
		if(authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
			try {

				String refresh_token = authorizationHeader.substring("Bearer ".length());
				Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
				JWTVerifier verifier = JWT.require(algorithm).build();
				DecodedJWT decodedJWT = verifier.verify(refresh_token);
				String username = decodedJWT.getSubject();
				User user = userService.getUser(username);
				String access_token = JWT.create()
						.withSubject(user.getUserName())
						.withExpiresAt(new Date(System.currentTimeMillis() + 1440 * 60 * 1000 ))
						.withIssuer(request.getRequestURL().toString())
						.withClaim("roles", user.getRoles().stream().map(Role::getLibelle).collect(Collectors.toList()))
						.sign(algorithm);

				
				Map<String,String> tokens = new HashMap<>();
				tokens.put("access_token", access_token);
				tokens.put("refresh_token", refresh_token);
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(),tokens);
				
			}catch(Exception exception) {
				response.setHeader("Error", exception.getMessage());
				response.setStatus(403);
				
				Map<String,String> error = new HashMap<>();
				error.put("error_message", exception.getMessage());
				response.setContentType("application/json");
				new ObjectMapper().writeValue(response.getOutputStream(),error);
			}
		}else {
			throw new RuntimeException("Refresh Token is missing");
		}
	}

}



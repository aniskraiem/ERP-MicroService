package tn.esprit.spring.filter;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import tn.esprit.spring.entites.User;
import tn.esprit.spring.services.userService;
import tn.esprit.spring.services.userServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;


public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter{
	
	
	private  userServiceImpl userservice;
	
	private final AuthenticationManager authenticationManager;
	
	
	public CustomAuthenticationFilter(AuthenticationManager authenticationManager) {
		this.authenticationManager = authenticationManager;
	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		/*String username = request.getParameter("username");
		String password = request.getParameter("password");*/
		String username,password;
		try {
			Map<String,String> requestMap = new ObjectMapper().readValue(request.getInputStream(),Map.class);
			username = requestMap.get("username");
			password = requestMap.get("password");
		} catch(IOException e) {
			throw new AuthenticationServiceException(e.getMessage(),e);
		}
		UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
		return authenticationManager.authenticate(authenticationToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
			Authentication authentication) throws IOException, ServletException {
		org.springframework.security.core.userdetails.User user = (org.springframework.security.core.userdetails.User)authentication.getPrincipal();
		Algorithm algorithm = Algorithm.HMAC256("secret".getBytes());
		String access_token = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 1440 * 60 * 1000 ))
				.withIssuer(request.getRequestURL().toString())
				.withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.sign(algorithm);
		
		String refresh_token = JWT.create()
				.withSubject(user.getUsername())
				.withExpiresAt(new Date(System.currentTimeMillis() + 14400 * 60 * 1000 ))
				.withIssuer(request.getRequestURL().toString())
				.sign(algorithm);

		/*response.setHeader("access_token", access_token);
		response.setHeader("refresh_token", refresh_token);*/
		ServletContext servletContext = request.getServletContext();
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(servletContext);
		userservice = webApplicationContext.getBean(userServiceImpl.class);
		User customUser = userservice.getUser(user.getUsername());
		Map<String,String> tokens = new HashMap<>();
		tokens.put("access_token", access_token);
		tokens.put("refresh_token", refresh_token);
		tokens.put("id", Integer.toString(customUser.getId()));
		tokens.put("username", user.getUsername());
		tokens.put("email", customUser.getEmail());
		tokens.put("name", customUser.getEmail());
		tokens.put("lastname", customUser.getLastName());
		tokens.put("ROLE", user.getAuthorities().toString());
		
		response.setContentType("application/json");
		new ObjectMapper().writeValue(response.getOutputStream(),tokens);
    
	}
	
	
	
	
}

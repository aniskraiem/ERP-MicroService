package tn.esprit.spring.entites;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="User")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String userName;
	private String email;
	private String password;
	private String name;
	private String lastName;
	
	@ManyToMany(cascade = CascadeType.PERSIST, fetch= FetchType.EAGER)
	private Set<Role> roles;

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", email=" + email + ", password=" + password + ", name="
				+ name + ", lastName=" + lastName + ", roles=" + roles + "]";
	}

}

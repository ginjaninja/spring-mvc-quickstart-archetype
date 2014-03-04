package ${package}.account;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@SuppressWarnings("serial")
@Entity
@Table(name = "account")
@NamedQuery(name = Account.FIND_BY_EMAIL, query = "select a from Account a where a.email = :email")
/**
 * Class for authenticating users. Relies on User for detailed info.
 *
 */
public class Account implements java.io.Serializable {

	public static final String FIND_BY_EMAIL = "Account.findByEmail";

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true, nullable=false)
	private String email;
	
	@Column(unique = true, nullable=false)
	private String username;
	
	@JsonIgnore
	@Column(nullable=false)
	private String password;

	private String role = "ROLE_USER";

    protected Account() {

	}
	
	public Account(String email, String password, String username, String role) {
		this.email = email;
		this.password = password;
		this.username = username;
		this.role = role;
	}

	public Long getId() {
		return id;
	}

    public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}

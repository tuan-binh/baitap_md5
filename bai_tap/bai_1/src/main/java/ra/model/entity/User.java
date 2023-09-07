package ra.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotEmpty
	@Size(min = 6)
	@Column(name = "full_name")
	private String fullName;
	@NotEmpty
	@Size(min = 6)
	private String username;
	@NotEmpty
	@Size(min = 6)
	private String password;
	@NotEmpty
	@Size(min = 6)
	private boolean status = true;
	
	public User() {
	}
	
	public User(Long id,@NotEmpty @Size(min = 6) String fullName,@NotEmpty @Size(min = 6) String username,@NotEmpty @Size(min = 6) String password, boolean status) {
		this.id = id;
		this.fullName = fullName;
		this.username = username;
		this.password = password;
		this.status = status;
	}
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
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
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
}

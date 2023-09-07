package ra.model.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class RegisterDTO {
	@NotEmpty
	private String fullName;
	@NotEmpty
	@Size(min = 6)
	private String username;
	@NotEmpty
	@Size(min = 6)
	private String password;
	
	public RegisterDTO() {
	}
	
	public RegisterDTO(@NotEmpty String fullName,@NotEmpty @Size(min = 6) String username,@NotEmpty @Size(min = 6) String password) {
		this.fullName = fullName;
		this.username = username;
		this.password = password;
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
}

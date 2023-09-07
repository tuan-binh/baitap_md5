package ra.demo_spring_boot.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerRequest {
	@NotEmpty(message = "name is invalid")
	private String name;
	@Min(value = 18, message = "Age must be between 18 and 100")
	@Max(value = 100, message = "Age must be between 18 and 100")
	private int age;
	private boolean gender;
//	@Pattern(regexp = "^(.+)@(\\\\S+)$", message = "Email is not valid")
	private String email;
//	@Pattern(regexp = "^0\\\\d{9,10}$", message = "phone is not valid")
	private String phoneNumber;
	
}

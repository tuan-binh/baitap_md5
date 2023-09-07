package ra.demo_spring_boot.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerResponse {
	private Long id;
	private String name;
	private int age;
	private boolean gender;
	private String email;
	private String phoneNumber;
	
}

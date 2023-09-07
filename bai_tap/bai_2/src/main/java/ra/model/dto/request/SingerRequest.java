package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SingerRequest {
	
	@NotEmpty(message = "singer name not empty")
	@NotBlank(message = "singer name not blank")
	@Pattern(regexp = "[\\w\\s]/gi")
	private String name;
	
	private boolean status = true;
}

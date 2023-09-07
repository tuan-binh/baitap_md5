package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ProductRequest {
	@NotNull(message = "product name not null")
	@NotEmpty(message = "product name not empty")
	@NotBlank(message = "product name not blank")
	private String name;
	
	@NotNull(message = "product name not null")
	@NotEmpty(message = "product name not empty")
	@Min(0)
	private double price;
	
	private boolean status = true;
}

package ra.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "singer")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Singer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "singer_name")
	private String name;
	
	private boolean status;
	
}

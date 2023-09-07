package ra.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "genre")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Genre {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "genre_name")
	private String name;
	
	@Column(name = "status")
	private boolean status;
	
}

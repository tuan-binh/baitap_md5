package ra.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.Genre;
import ra.model.domain.Singer;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SongResponse {
	private Long id;
	
	private String name;
	
	private Genre genre;
	
	private Singer singer;
}

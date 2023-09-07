package ra.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.model.domain.Genre;
import ra.model.domain.Singer;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SongRequest {
	
	@NotEmpty(message = "song name not empty")
	@NotBlank(message = "song name not blank")
	@Pattern(regexp = "[\\w\\s]/gi")
	private String name;
	
	@NotNull(message = "genre not null for song")
	private Genre genre;
	
	@NotNull(message = "singer not null for song")
	private Singer singer;
}

package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Genre;
import ra.model.dto.request.GenreRequest;
import ra.model.dto.response.GenreResponse;
import ra.service.IGenericMapper;

@Component
public class GenreMapper implements IGenericMapper<Genre, GenreRequest, GenreResponse> {
	@Override
	public Genre toEntity(GenreRequest genreRequest) {
		return Genre.builder()
				  .name(genreRequest.getName())
				  .status(genreRequest.isStatus())
				  .build();
	}
	
	@Override
	public GenreResponse toResponse(Genre genre) {
		return GenreResponse.builder()
				  .id(genre.getId())
				  .name(genre.getName())
				  .status(genre.isStatus())
				  .build();
	}
}

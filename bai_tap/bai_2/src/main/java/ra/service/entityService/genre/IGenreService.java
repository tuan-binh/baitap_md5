package ra.service.entityService.genre;

import ra.exception.GenreException;
import ra.model.domain.Genre;
import ra.model.dto.request.GenreRequest;
import ra.model.dto.response.GenreResponse;

import java.util.List;

public interface IGenreService {
	
	List<GenreResponse> findAll();
	GenreResponse findById(Long id);
	GenreResponse save(GenreRequest genreRequest) throws GenreException;
	GenreResponse update(GenreRequest genreRequest,Long id) throws GenreException;
	GenreResponse delete(Long id);
	
}

package ra.service.entityService.genre;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exception.GenreException;
import ra.model.domain.Genre;
import ra.model.dto.request.GenreRequest;
import ra.model.dto.response.GenreResponse;
import ra.repository.IGenreRepository;
import ra.service.mapper.GenreMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class GenreService implements IGenreService {
	
	@Autowired
	private IGenreRepository genreRepository;
	@Autowired
	private GenreMapper genreMapper;
	
	@Override
	public List<GenreResponse> findAll() {
		return genreRepository.findAll().stream()
				  .map((item) -> genreMapper.toResponse(item))
				  .collect(Collectors.toList());
	}
	
	@Override
	public GenreResponse findById(Long id) {
		Optional<Genre> genreOptional = genreRepository.findById(id);
		return genreOptional.map(genre -> genreMapper.toResponse(genre)).orElse(null);
	}
	
	@Override
	public GenreResponse save(GenreRequest genreRequest) throws GenreException {
		if (genreRepository.existsByName(genreRequest.getName())) {
			throw new GenreException("exists genre name");
		}
		return genreMapper.toResponse(genreRepository.save(genreMapper.toEntity(genreRequest)));
	}
	
	@Override
	public GenreResponse update(GenreRequest genreRequest, Long id) throws GenreException {
		if (genreRepository.existsByName(genreRequest.getName())) {
			throw new GenreException("exists genre");
		}
		Genre genre = genreMapper.toEntity(genreRequest);
		genre.setId(id);
		return genreMapper.toResponse(genreRepository.save(genreMapper.toEntity(genreRequest)));
	}
	
	@Override
	public GenreResponse delete(Long id) {
		Optional<Genre> genreOptional = genreRepository.findById(id);
		if (genreOptional.isPresent()) {
			genreRepository.deleteById(id);
			return genreMapper.toResponse(genreOptional.get());
		}
		return null;
	}
}


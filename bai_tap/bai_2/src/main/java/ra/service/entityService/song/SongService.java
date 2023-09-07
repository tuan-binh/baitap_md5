package ra.service.entityService.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exception.SongException;
import ra.model.domain.Song;
import ra.model.dto.request.SongRequest;
import ra.model.dto.response.SongResponse;
import ra.repository.ISongRepository;
import ra.service.mapper.SongMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SongService implements ISongService {
	
	@Autowired
	private ISongRepository songRepository;
	@Autowired
	private SongMapper songMapper;
	
	@Override
	public List<SongResponse> findAll() {
		return songRepository.findAll().stream()
				  .map((item) -> songMapper.toResponse(item))
				  .collect(Collectors.toList());
	}
	
	@Override
	public SongResponse findById(Long id) {
		Optional<Song> songOptional = songRepository.findById(id);
		return songOptional.map(genre -> songMapper.toResponse(genre)).orElse(null);
	}
	
	@Override
	public SongResponse save(SongRequest songRequest) throws SongException {
		if(songRepository.existsByName(songRequest.getName())) {
			throw new SongException("exists song name");
		}
		return songMapper.toResponse(songRepository.save(songMapper.toEntity(songRequest)));
	}
	
	@Override
	public SongResponse update(SongRequest songRequest, Long id) throws SongException {
		if(songRepository.existsByName(songRequest.getName())) {
			throw new SongException("exists song name");
		}
		Song song = songMapper.toEntity(songRequest);
		song.setId(id);
		return songMapper.toResponse(songRepository.save(songMapper.toEntity(songRequest)));
	}
	
	@Override
	public SongResponse delete(Long id) {
		Optional<Song> songOptional = songRepository.findById(id);
		if (songOptional.isPresent()) {
			songRepository.deleteById(id);
			return songMapper.toResponse(songOptional.get());
		}
		return null;
	}
}

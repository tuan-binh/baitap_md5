package rikkei.academy.model.service.song;

import rikkei.academy.model.dto.request.SongDTO;
import rikkei.academy.model.entity.Song;

import java.util.List;

public interface ISongService {
	List<Song> findAll();
	
	void save(SongDTO song);
	
	void delete(Long id);
	
	Song findById(Long id);
}

package ra.service.entityService.song;

import ra.exception.SongException;
import ra.model.dto.request.SongRequest;
import ra.model.dto.response.SongResponse;

import java.util.List;

public interface ISongService {
	List<SongResponse> findAll();
	
	SongResponse findById(Long id);
	
	SongResponse save(SongRequest songRequest) throws SongException;
	
	SongResponse update(SongRequest songRequest, Long id) throws SongException;
	
	SongResponse delete(Long id);
}

package ra.service.entityService.singer;

import ra.exception.SingerException;
import ra.model.dto.request.SingerRequest;
import ra.model.dto.response.SingerResponse;

import java.util.List;

public interface ISingerService {
	List<SingerResponse> findAll();
	
	SingerResponse findById(Long id);
	
	SingerResponse save(SingerRequest singerRequest) throws SingerException;
	
	SingerResponse update(SingerRequest singerRequest, Long id) throws SingerException;
	
	SingerResponse delete(Long id);
}

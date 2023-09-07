package ra.service.entityService.singer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.exception.SingerException;
import ra.model.domain.Singer;
import ra.model.dto.request.SingerRequest;
import ra.model.dto.response.SingerResponse;
import ra.repository.ISingerRepository;
import ra.service.mapper.SingerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SingerService implements ISingerService {
	
	@Autowired
	private ISingerRepository singerRepository;
	@Autowired
	private SingerMapper singerMapper;
	
	@Override
	public List<SingerResponse> findAll() {
		return singerRepository.findAll().stream()
				  .map((item) -> singerMapper.toResponse(item))
				  .collect(Collectors.toList());
	}
	
	@Override
	public SingerResponse findById(Long id) {
		Optional<Singer> singerOptional = singerRepository.findById(id);
		return singerOptional.map(genre -> singerMapper.toResponse(genre)).orElse(null);
	}
	
	@Override
	public SingerResponse save(SingerRequest singerRequest) throws SingerException {
		if(singerRepository.existsByName(singerRequest.getName())) {
			throw new SingerException("exists singer name");
		}
		return singerMapper.toResponse(singerRepository.save(singerMapper.toEntity(singerRequest)));
	}
	
	@Override
	public SingerResponse update(SingerRequest singerRequest, Long id) throws SingerException {
		if(singerRepository.existsByName(singerRequest.getName())) {
			throw new SingerException("exists singer name");
		}
		Singer singer = singerMapper.toEntity(singerRequest);
		singer.setId(id);
		return singerMapper.toResponse(singerRepository.save(singerMapper.toEntity(singerRequest)));
	}
	
	@Override
	public SingerResponse delete(Long id) {
		Optional<Singer> singerOptional = singerRepository.findById(id);
		if (singerOptional.isPresent()) {
			singerRepository.deleteById(id);
			return singerMapper.toResponse(singerOptional.get());
		}
		return null;
	}
}

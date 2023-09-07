package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Singer;
import ra.model.dto.request.SingerRequest;
import ra.model.dto.response.SingerResponse;
import ra.service.IGenericMapper;

@Component
public class SingerMapper implements IGenericMapper<Singer, SingerRequest, SingerResponse> {
	@Override
	public Singer toEntity(SingerRequest singerRequest) {
		return Singer.builder()
				  .name(singerRequest.getName())
				  .build();
	}
	
	@Override
	public SingerResponse toResponse(Singer singer) {
		return SingerResponse.builder()
				  .id(singer.getId())
				  .name(singer.getName())
				  .status(singer.isStatus())
				  .build();
	}
}

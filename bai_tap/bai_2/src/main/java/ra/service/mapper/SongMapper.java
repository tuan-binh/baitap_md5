package ra.service.mapper;

import org.springframework.stereotype.Component;
import ra.model.domain.Song;
import ra.model.dto.request.SongRequest;
import ra.model.dto.response.SongResponse;
import ra.service.IGenericMapper;

@Component
public class SongMapper implements IGenericMapper<Song, SongRequest, SongResponse> {
	
	@Override
	public Song toEntity(SongRequest songRequest) {
		return Song.builder()
				  .name(songRequest.getName())
				  .genre(songRequest.getGenre())
				  .singer(songRequest.getSinger())
				  .build();
	}
	
	@Override
	public SongResponse toResponse(Song song) {
		return SongResponse.builder()
				  .id(song.getId())
				  .name(song.getName())
				  .genre(song.getGenre())
				  .singer(song.getSinger())
				  .build();
	}
}

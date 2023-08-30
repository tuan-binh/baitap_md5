package rikkei.academy.model.service.song;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;
import rikkei.academy.model.dto.request.SongDTO;
import rikkei.academy.model.entity.Song;
import rikkei.academy.model.repository.song.ISongRepository;
import rikkei.academy.model.repository.song.SongRepository;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@PropertySource({"classpath:upload.properties"})
public class SongService implements ISongService {
	
	@Value("${upload_path}")
	private String pathUpload;
	@Autowired
	private ISongRepository songRepository;
	
	@Override
	public List<Song> findAll() {
		return songRepository.findAll();
	}
	
	@Override
	public void save(SongDTO song) {
		String filename = null;
		if (!song.getUrl().isEmpty()) {
			filename = song.getUrl().getOriginalFilename();
			try {
				FileCopyUtils.copy(song.getUrl().getBytes(), new File(pathUpload + filename));
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		Song newSong = new Song(song.getId(), song.getName(), song.getAuthor(), song.getGenre(), filename, song.isStatus());
		songRepository.save(newSong);
	}
	
	@Override
	public void delete(Long id) {
		songRepository.delete(id);
	}
	
	@Override
	public Song findById(Long id) {
		return songRepository.findById(id);
	}
}

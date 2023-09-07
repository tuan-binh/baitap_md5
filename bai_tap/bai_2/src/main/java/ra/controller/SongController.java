package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exception.SongException;
import ra.model.dto.request.SongRequest;
import ra.model.dto.response.SongResponse;
import ra.service.entityService.song.ISongService;

import java.util.List;

@RestController
@RequestMapping({"/song"})
public class SongController {
	
	@Autowired
	private ISongService songService;
	
	@GetMapping
	public ResponseEntity<List<SongResponse>> getAllSong() {
		List<SongResponse> songs = songService.findAll();
		if (songs.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(songs, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SongResponse> getSongById(@PathVariable Long id) {
		return new ResponseEntity<>(songService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SongResponse> handleAddSong(@RequestBody SongRequest songRequest) throws SongException {
		return new ResponseEntity<>(songService.save(songRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SongResponse> handleUpdateSong(@RequestBody SongRequest songRequest, @PathVariable Long id) throws SongException {
		return new ResponseEntity<>(songService.update(songRequest, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SongResponse> handleDeleteSong(@PathVariable Long id) {
		return new ResponseEntity<>(songService.delete(id), HttpStatus.OK);
	}
	
}

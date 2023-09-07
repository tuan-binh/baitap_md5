package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exception.GenreException;
import ra.model.dto.request.GenreRequest;
import ra.model.dto.response.GenreResponse;
import ra.service.entityService.genre.IGenreService;

import java.util.List;

@RestController
@RequestMapping({"/genre"})
public class GenreController {
	
	@Autowired
	private IGenreService genreService;
	
	@GetMapping
	public ResponseEntity<List<GenreResponse>> getAllGenre() {
		List<GenreResponse> genres = genreService.findAll();
		if (genres.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(genres, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<GenreResponse> getGenreById(@PathVariable Long id) {
		return new ResponseEntity<>(genreService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<GenreResponse> handleAddGenre(@RequestBody GenreRequest genreRequest) throws GenreException {
		return new ResponseEntity<>(genreService.save(genreRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<GenreResponse> handleUpdateGenre(@RequestBody GenreRequest genreRequest, @PathVariable Long id) throws GenreException {
		return new ResponseEntity<>(genreService.update(genreRequest, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<GenreResponse> handleDeleteGenre(@PathVariable Long id) {
		return new ResponseEntity<>(genreService.delete(id), HttpStatus.OK);
	}
	
}

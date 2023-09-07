package ra.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.exception.GenreException;
import ra.exception.SingerException;
import ra.exception.SongException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class ApplicationHandler {
	
	@ExceptionHandler
	public ResponseEntity<Map<String, String>> invalidRequest(MethodArgumentNotValidException ex) {
		Map<String, String> err = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(c -> {
			err.put(c.getField(), c.getDefaultMessage());
		});
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SongException.class)
	public ResponseEntity<String> existedSong(SongException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SingerException.class)
	public ResponseEntity<String> existedSinger(SingerException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(GenreException.class)
	public ResponseEntity<String> existedGenre(GenreException ex) {
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}

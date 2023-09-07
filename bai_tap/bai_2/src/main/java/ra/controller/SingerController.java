package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.exception.SingerException;
import ra.model.dto.request.SingerRequest;
import ra.model.dto.response.SingerResponse;
import ra.service.entityService.singer.ISingerService;

import java.util.List;

@RestController
@RequestMapping({"/singer"})
public class SingerController {
	
	@Autowired
	private ISingerService singerService;
	
	@GetMapping
	public ResponseEntity<List<SingerResponse>> getAllSinger() {
		List<SingerResponse> singers = singerService.findAll();
		if (singers.isEmpty()) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(singers, HttpStatus.OK);
	}
	
	@GetMapping("{id}")
	public ResponseEntity<SingerResponse> getSingerById(@PathVariable Long id) {
		return new ResponseEntity<>(singerService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<SingerResponse> handleAddSinger(@RequestBody SingerRequest singerRequest) throws SingerException {
		return new ResponseEntity<>(singerService.save(singerRequest), HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SingerResponse> handleUpdateSinger(@RequestBody SingerRequest singerRequest, @PathVariable Long id) throws SingerException {
		return new ResponseEntity<>(singerService.update(singerRequest, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<SingerResponse> handleDeleteSinger(@PathVariable Long id) {
		return new ResponseEntity<>(singerService.delete(id), HttpStatus.OK);
	}
	
}

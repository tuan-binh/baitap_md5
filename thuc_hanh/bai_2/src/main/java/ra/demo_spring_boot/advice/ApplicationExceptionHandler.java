package ra.demo_spring_boot.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ra.demo_spring_boot.exception.CustomerException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice // Cho phép can thiệp vào quá trình tiệp nhận request nếu xảy ra ngoại lệ
public class ApplicationExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> invalidRequest(MethodArgumentNotValidException ex) {
		Map<String, String> err = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(e -> {
			err.put(e.getField(), e.getDefaultMessage());
		});
		return new ResponseEntity<>(err, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(CustomerException.class)
	public String exists(CustomerException ex) {
		return ex.getMessage();
	}
	
}

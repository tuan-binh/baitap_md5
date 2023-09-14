package ra.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.web.bind.annotation.*;
import ra.model.dto.request.UserFormLogin;
import ra.model.dto.request.UserFormRegister;
import ra.model.dto.response.JwtResponse;
import ra.security.jwt.JwtProvider;
import ra.security.user_principle.UserPrinciple;
import ra.service.user.IUserService;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping({"/api/v4/auth"})
@CrossOrigin("*")
public class AuthController {
	
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtProvider jwtProvider;
	@Autowired
	private IUserService userService;
	
	@GetMapping
	public ResponseEntity<String> home() {
		return ResponseEntity.ok("Welcome to my website");
	}
	
	@PostMapping("/login")
	public ResponseEntity<JwtResponse> handleLogin(@RequestBody UserFormLogin userFormLogin) {
		Authentication authentication = authenticationManager.authenticate(
				  new UsernamePasswordAuthenticationToken(userFormLogin.getUsername(), userFormLogin.getPassword())
		); // Tạo đối tượng authentication để xác thực thông qua username và password
		// tạo token sau khi đăng nhập thành công không thì throw ra một lỗi
		UserPrinciple userPrinciple = (UserPrinciple) authentication.getPrincipal();
		String token = jwtProvider.generateToken(userPrinciple);
		List<String> roles = userPrinciple.getAuthorities().stream()
				  .map(GrantedAuthority::getAuthority).collect(Collectors.toList());
		return ResponseEntity.ok(JwtResponse.builder()
				  .token(token)
				  .type("Bearer")
				  .name(userPrinciple.getName())
				  .username(userPrinciple.getUsername())
				  .status(userPrinciple.isStatus())
				  .roles(roles)
				  .build());
	}
	
	@PostMapping("/register")
	private ResponseEntity<String> signup(@RequestBody UserFormRegister userFormRegister) {
		userService.save(userFormRegister);
		return new ResponseEntity<>("success", HttpStatus.CREATED);
		
	}
	
}

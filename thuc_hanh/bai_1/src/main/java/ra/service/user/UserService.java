package ra.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ra.model.domain.Role;
import ra.model.domain.RoleName;
import ra.model.domain.Users;
import ra.model.dto.request.UserFormRegister;
import ra.repository.IUserRepository;
import ra.service.role.IRoleService;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	@Autowired
	private IRoleService roleService;
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public List<Users> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public Optional<Users> findByUserName(String username) {
		return userRepository.findByUsername(username);
	}
	
	@Override
	public Users save(UserFormRegister userFormRegister) {
		if (userRepository.existsByUsername(userFormRegister.getUsername())) {
			throw new RuntimeException("User is exists");
		}
		Set<Role> roles = new HashSet<>();
		if (userFormRegister.getRoles().isEmpty() || userFormRegister.getRoles() == null) {
			roles.add(roleService.findByRoleName(RoleName.ROLE_USER));
		} else {
			userFormRegister.getRoles().forEach(role -> {
				switch (role) {
					case "admin":
						roles.add(roleService.findByRoleName(RoleName.ROLE_ADMIN));
					case "seller":
						roles.add(roleService.findByRoleName(RoleName.ROLE_SELLER));
					case "user":
						roles.add(roleService.findByRoleName(RoleName.ROLE_USER));
				}
			});
		}
		
		Users user = Users.builder()
				  .name(userFormRegister.getName())
				  .username(userFormRegister.getUsername())
				  .password(passwordEncoder.encode(userFormRegister.getPassword()))
				  .status(true)
				  .roles(roles)
				  .build();
		
		
		return userRepository.save(user);
	}
}

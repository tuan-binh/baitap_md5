package ra.service.user;

import ra.model.domain.Users;
import ra.model.dto.request.UserFormRegister;

import java.util.List;
import java.util.Optional;

public interface IUserService {
	
	List<Users> findAll();
	
	Optional<Users> findByUserName(String username);
	
	Users save(UserFormRegister userFormRegister);
	
}

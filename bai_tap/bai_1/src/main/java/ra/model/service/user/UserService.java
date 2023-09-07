package ra.model.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.User;
import ra.model.repository.IUserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {
	
	@Autowired
	private IUserRepository userRepository;
	
	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}
	
	@Override
	public User findById(Long id) {
		Optional<User> optionalUser = userRepository.findById(id);
		return optionalUser.orElse(null);
	}
	
	@Override
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Override
	public User delete(Long id) {
		if (findById(id) == null) {
			return null;
		}
		User oldUser = findById(id);
		userRepository.deleteById(id);
		return oldUser;
	}
}

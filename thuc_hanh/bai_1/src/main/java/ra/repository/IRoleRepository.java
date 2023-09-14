package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Role;
import ra.model.domain.RoleName;

import java.util.Optional;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Long> {
	Optional<Role> findByRoleName(RoleName roleName);
	
}


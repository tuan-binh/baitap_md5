package ra.service.role;

import ra.model.domain.Role;
import ra.model.domain.RoleName;

public interface IRoleService {
	Role findByRoleName(RoleName roleName);
}

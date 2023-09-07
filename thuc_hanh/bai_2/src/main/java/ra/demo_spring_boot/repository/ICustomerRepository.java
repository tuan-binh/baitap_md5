package ra.demo_spring_boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.demo_spring_boot.model.domain.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {
	
	boolean existsByEmail(String email);
	
	boolean existsByPhoneNumber(String phone);
	
}

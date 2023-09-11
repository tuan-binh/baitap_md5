package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ra.model.entity.SmartPhone;

public interface ISmartPhoneRepository extends JpaRepository<SmartPhone,Long> {
	
	Iterable<SmartPhone> findAllByProducerContaining(String producer);
	
}

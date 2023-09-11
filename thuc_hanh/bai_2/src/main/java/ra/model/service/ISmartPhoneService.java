package ra.model.service;

import ra.model.entity.SmartPhone;

import java.util.Optional;

public interface ISmartPhoneService {
	Iterable<SmartPhone> findAllByProducerContaining(String producer);
	Iterable<SmartPhone> findAll();
	Optional<SmartPhone> findById(Long id);
	void deleteById(Long id);
	SmartPhone save(SmartPhone smartPhone);
}

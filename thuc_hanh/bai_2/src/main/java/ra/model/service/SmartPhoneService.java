package ra.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.model.entity.SmartPhone;
import ra.model.repository.ISmartPhoneRepository;

import java.util.Optional;

@Service
public class SmartPhoneService implements ISmartPhoneService {

	@Autowired
	private ISmartPhoneRepository smartPhoneRepository;
	
	@Override
	public Iterable<SmartPhone> findAllByProducerContaining(String producer) {
		return smartPhoneRepository.findAllByProducerContaining(producer);
	}
	
	@Override
	public Iterable<SmartPhone> findAll() {
		return smartPhoneRepository.findAll();
	}
	
	@Override
	public Optional<SmartPhone> findById(Long id) {
		return smartPhoneRepository.findById(id);
	}
	
	@Override
	public void deleteById(Long id) {
		smartPhoneRepository.deleteById(id);
	}
	
	@Override
	public SmartPhone save(SmartPhone smartPhone) {
		return smartPhoneRepository.save(smartPhone);
	}
}

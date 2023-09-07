package ra.demo_spring_boot.service.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.demo_spring_boot.exception.CustomerException;
import ra.demo_spring_boot.model.domain.Customer;
import ra.demo_spring_boot.model.dto.request.CustomerRequest;
import ra.demo_spring_boot.model.dto.response.CustomerResponse;
import ra.demo_spring_boot.repository.ICustomerRepository;
import ra.demo_spring_boot.service.mapper.CustomerMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	@Autowired
	private CustomerMapper customerMapper;
	
	@Override
	public List<CustomerResponse> findAll() {
		return customerRepository.findAll().stream()
				  .map((item) -> customerMapper.toResponse(item))
				  .collect(Collectors.toList());
	}
	
	@Override
	public CustomerResponse findById(Long id) {
		Optional<Customer> optionalCustomer = customerRepository.findById(id);
		return optionalCustomer.map(customer -> customerMapper.toResponse(customer)).orElse(null);
	}
	
	@Override
	public CustomerResponse save(CustomerRequest customerRequest) throws CustomerException {
		if (customerRepository.existsByEmail(customerRequest.getEmail())) {
			throw new CustomerException("Email is exists");
		}
		if (customerRepository.existsByPhoneNumber(customerRequest.getPhoneNumber())) {
			throw new CustomerException("Phone is exists");
		}
		return customerMapper.toResponse(customerRepository.save(customerMapper.toEntity(customerRequest)));
	}
	
	@Override
	public CustomerResponse update(CustomerRequest customerRequest, Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isPresent()) {
			return customerMapper.toResponse(customerRepository.save(customerMapper.toEntity(customerRequest)));
		}
		return null;
	}
	
	@Override
	public CustomerResponse delete(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		if (customerOptional.isPresent()) {
			Customer customer = customerOptional.get();
			customerRepository.deleteById(id);
			return customerMapper.toResponse(customer);
		}
		return null;
	}
}

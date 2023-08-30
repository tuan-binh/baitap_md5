package rikkei.academy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.repository.customer.ICustomerRepository;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
	
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public List<Customer> findAll() {
		return customerRepository.findAll();
	}
	
	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);
	}
	
	@Override
	public void delete(Long id) {
		customerRepository.delete(id);
	}
	
	@Override
	public Customer findById(Long id) {
		return customerRepository.findById(id);
	}
}

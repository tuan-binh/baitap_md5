package rikkei.academy.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.entity.Customer;
import rikkei.academy.model.repository.ICustomerRepository;

@Service
public class CustomerService implements ICustomerService{
	@Autowired
	private ICustomerRepository customerRepository;
	
	@Override
	public boolean insertWithStoredProcedure(Customer customer) {
		return customerRepository.insertWithStoredProcedure(customer);
	}
}

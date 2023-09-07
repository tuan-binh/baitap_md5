package ra.demo_spring_boot.service.customer;

import ra.demo_spring_boot.exception.CustomerException;
import ra.demo_spring_boot.model.dto.request.CustomerRequest;
import ra.demo_spring_boot.model.dto.response.CustomerResponse;

import java.util.List;

public interface ICustomerService {
	List<CustomerResponse> findAll();
	
	CustomerResponse findById(Long id);
	
	CustomerResponse save(CustomerRequest customerRequest) throws CustomerException;
	
	CustomerResponse update(CustomerRequest customerRequest, Long id);
	
	CustomerResponse delete(Long id);
	
}

package ra.demo_spring_boot.service.mapper;

import org.springframework.stereotype.Component;
import ra.demo_spring_boot.model.domain.Customer;
import ra.demo_spring_boot.model.dto.request.CustomerRequest;
import ra.demo_spring_boot.model.dto.response.CustomerResponse;
import ra.demo_spring_boot.service.IGenericMapper;

@Component
public class CustomerMapper implements IGenericMapper<Customer, CustomerRequest, CustomerResponse> {
	@Override
	public Customer toEntity(CustomerRequest customerRequest) {
		return Customer.builder()
				  .name(customerRequest.getName())
				  .email(customerRequest.getEmail())
				  .phoneNumber(customerRequest.getPhoneNumber())
				  .age(customerRequest.getAge())
				  .gender(customerRequest.isGender())
				  .build();
	}
	
	@Override
	public CustomerRequest toRequest(Customer customer) {
		return CustomerRequest.builder()
				  .name(customer.getName())
				  .age(customer.getAge())
				  .email(customer.getEmail())
				  .gender(customer.isGender())
				  .phoneNumber(customer.getPhoneNumber())
				  .build();
	}
	
	@Override
	public CustomerResponse toResponse(Customer customer) {
		return CustomerResponse.builder()
				  .id(customer.getId())
				  .name(customer.getName())
				  .age(customer.getAge())
				  .email(customer.getEmail())
				  .gender(customer.isGender())
				  .phoneNumber(customer.getPhoneNumber())
				  .build();
	}
}

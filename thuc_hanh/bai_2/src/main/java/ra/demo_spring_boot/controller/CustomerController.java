package ra.demo_spring_boot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ra.demo_spring_boot.exception.CustomerException;
import ra.demo_spring_boot.model.dto.request.CustomerRequest;
import ra.demo_spring_boot.model.dto.response.CustomerResponse;
import ra.demo_spring_boot.service.customer.ICustomerService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping({"/api/v2/customer"})
public class CustomerController {
	
	@Autowired
	private ICustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<CustomerResponse>> getAllCustomer() {
		return new ResponseEntity<>(customerService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CustomerResponse> getCustomerById(@PathVariable Long id) {
		return new ResponseEntity<>(customerService.findById(id), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<CustomerResponse> addNewCustomer(@RequestBody @Valid CustomerRequest customerRequest) throws CustomerException {
		return new ResponseEntity<>(customerService.save(customerRequest), HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}")
	public ResponseEntity<CustomerResponse> updateCustomer(@RequestBody @Valid CustomerRequest customerRequest, @PathVariable Long id) {
		return new ResponseEntity<>(customerService.update(customerRequest, id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<CustomerResponse> deleteCustomer(@PathVariable Long id) {
		return new ResponseEntity<>(customerService.delete(id), HttpStatus.OK);
	}
	
}

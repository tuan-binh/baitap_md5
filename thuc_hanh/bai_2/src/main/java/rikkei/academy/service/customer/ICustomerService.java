package rikkei.academy.service.customer;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import rikkei.academy.model.Customer;
import rikkei.academy.model.Province;
import rikkei.academy.service.IGenerateService;

public interface ICustomerService extends IGenerateService<Customer> {
    Page<Customer> findAll(Pageable pageable);
    Page<Customer> findAllByFirstNameContaining(String firstname,Pageable pageable);
}

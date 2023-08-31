package rikkei.academy.model.service;

import rikkei.academy.model.entity.Customer;

public interface ICustomerService {
	boolean insertWithStoredProcedure(Customer customer);
}

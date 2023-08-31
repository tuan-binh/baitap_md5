package rikkei.academy.model.repository;

import rikkei.academy.model.entity.Customer;

public interface ICustomerRepository {
	boolean insertWithStoredProcedure(Customer customer);
}

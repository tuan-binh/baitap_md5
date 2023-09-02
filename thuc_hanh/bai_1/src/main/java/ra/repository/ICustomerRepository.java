package ra.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.Customer;
import ra.model.Province;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer,Long> {
	Iterable<Customer> findAllByProvince(Province province);
}

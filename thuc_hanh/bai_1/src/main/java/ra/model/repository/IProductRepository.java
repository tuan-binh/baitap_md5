package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ra.model.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {
	Page<Product> findAllByNameContaining(String name, Pageable pageable);
	
	@Query("select p from Product as p where p.name like concat('%',':name','%') ")
	Page<Product> findByNameProduct(@Param("name") String name, Pageable pageable);
}

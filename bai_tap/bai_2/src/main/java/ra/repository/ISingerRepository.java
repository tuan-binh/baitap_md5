package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Singer;

@Repository
public interface ISingerRepository extends JpaRepository<Singer, Long> {
	boolean existsByName(String singer);
}

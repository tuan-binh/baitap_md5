package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import ra.model.entity.Feedback;

public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback,Long> {
	Page<Feedback> findAll(Pageable pageable);
}

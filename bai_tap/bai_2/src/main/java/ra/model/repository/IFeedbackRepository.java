package ra.model.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import ra.model.entity.Feedback;

@Repository
public interface IFeedbackRepository extends PagingAndSortingRepository<Feedback,Long> {
}

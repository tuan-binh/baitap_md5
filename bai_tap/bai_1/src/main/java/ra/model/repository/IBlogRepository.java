package ra.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ra.model.entity.Blog;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
}

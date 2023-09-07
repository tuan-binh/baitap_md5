package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Genre;

@Repository
public interface IGenreRepository extends JpaRepository<Genre, Long> {
	boolean existsByName(String genre);
}

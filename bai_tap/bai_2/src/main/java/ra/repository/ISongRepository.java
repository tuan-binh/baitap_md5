package ra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.model.domain.Song;

@Repository
public interface ISongRepository extends JpaRepository<Song, Long> {
	boolean existsByName(String song);
}

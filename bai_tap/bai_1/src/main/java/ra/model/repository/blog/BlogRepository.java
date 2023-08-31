package ra.model.repository.blog;

import org.springframework.stereotype.Repository;
import ra.model.entity.Blog;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class BlogRepository implements IBlogRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Blog> findAll() {
		return entityManager.createQuery("SELECT b FROM Blog AS b", Blog.class)
				  .getResultList();
	}
	
	@Override
	public Blog findById(Long id) {
		return entityManager.createQuery("SELECT b FROM Blog AS b WHERE id=:id", Blog.class)
				  .setParameter("id", id)
				  .getSingleResult();
	}
	
	@Override
	public void save(Blog blog) {
		if (blog.getId() == null) {
			entityManager.persist(blog);
		} else {
			entityManager.merge(blog);
		}
	}
	
	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));
	}
}

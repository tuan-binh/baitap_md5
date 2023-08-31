package rikkei.academy.model.repository.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.entity.Todo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


// jpa core
@Repository
@Transactional
public class TodoRepository implements ITodoRepository {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public List<Todo> findAll() {
		// cấu lệnh hql để truy vấn và dùng chấm đến phương thức luôn
		return entityManager.createQuery("SELECT t FROM Todo AS t", Todo.class)
				  .getResultList();
	}
	
	@Override
	public Todo findById(Long id) {
		// câu lệnh truy vấn hql và dùng đến các phương thức khi trả vè đối tượng luôn
		return entityManager.createQuery("SELECT t FROM Todo AS t WHERE id=:id", Todo.class)
				  // set tham số để có tham số truy vấn
				  .setParameter("id", id)
				  .getSingleResult();
	}
	
	@Override
	public void save(Todo todo) {
		if (todo.getId() == null) {
			entityManager.persist(todo);
		} else {
			entityManager.merge(todo);
		}
	}
	
	@Override
	public void delete(Long id) {
		entityManager.remove(findById(id));
	}
}

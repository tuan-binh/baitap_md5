package rikkei.academy.model.service.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rikkei.academy.model.entity.Todo;
import rikkei.academy.model.repository.todo.ITodoRepository;

import java.util.List;

@Service
public class TodoService implements ITodoService{
	
	@Autowired
	private ITodoRepository todoRepository;
	
	@Override
	public List<Todo> findAll() {
		return todoRepository.findAll();
	}
	
	@Override
	public Todo findById(Long id) {
		return todoRepository.findById(id);
	}
	
	@Override
	public void save(Todo todo) {
		todoRepository.save(todo);
	}
	
	@Override
	public void delete(Long id) {
		todoRepository.delete(id);
	}
}

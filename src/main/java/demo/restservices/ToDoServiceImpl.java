package demo.restservices;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ToDoServiceImpl implements ToDoService {

	private static Map<Integer, ToDo> toDos = new HashMap<Integer, ToDo>();
	private int nextId = 1;
	
	// Populate collection with some simple toDos, to get the ball rolling.
	{
		insert(new ToDo("Tarefa AOS", true));
		insert(new ToDo("Tarefa de GenIA", false));
	}

	@Override
	public ToDo getToDo(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getToDo'");
	}

	@Override
	public Collection<ToDo> getToDos() {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'getToDos'");
	}

	@Override
	public void insert(ToDo toDo) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'insert'");
	}

	@Override
	public void update(ToDo toDo) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'update'");
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		throw new UnsupportedOperationException("Unimplemented method 'delete'");
	}
}

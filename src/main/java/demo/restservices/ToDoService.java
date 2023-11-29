package demo.restservices;

import java.util.Collection;

public interface ToDoService {

	ToDo getToDo(int id);
	Collection<ToDo> getToDos();

	void insert(ToDo toDo);
	void update(ToDo toDo);
	void delete(int id);
}

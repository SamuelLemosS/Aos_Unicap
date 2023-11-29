package demo.restservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;

@Controller
@RequestMapping(value="/tarefas")
@CrossOrigin
public class ToDoController {

	@Autowired
	private ToDoService service;

	// Get all toDos.
	@GetMapping(value="/toDos", produces={"application/json","application/xml"})
	public ResponseEntity<Collection<ToDo>> getToDos() {
		Collection<ToDo> result = service.getToDos();
		return ResponseEntity.ok().body(result);
	}

	// Get a specific toDo.
	@GetMapping(value="/toDo/{id}", produces={"application/json","application/xml"})
	public ResponseEntity<ToDo> getToDo(@PathVariable int id) {
		ToDo result = service.getToDo(id);
		if (service.getToDo(id) == null)
			return ResponseEntity.notFound().build();
		else
			return ResponseEntity.ok().body(result);
	}

	// Insert a new toDo.
	@PostMapping(value="/toDo",
			consumes={"application/json","application/xml"},
			produces={"application/json","application/xml"})
	public ResponseEntity<ToDo> addToDo(@RequestBody ToDo toDo) {
		service.insert(toDo);
		URI uri = URI.create("/item/" + toDo.getId());
		return ResponseEntity.created(uri).body(toDo);
	}

	// Update an existing toDo.
	@PutMapping(value="/toDo/{id}", consumes={"application/json","application/xml"})
	public ResponseEntity modifyToDo(@PathVariable int id, @RequestBody ToDo toDo) {
		if (service.getToDo(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.update(toDo);
			return ResponseEntity.ok().build();
		}
	}

	// Delete an existing toDo.
	@DeleteMapping("/toDo/{id}")
	public ResponseEntity deleteToDo(@PathVariable int id) {
		if (service.getToDo(id) == null)
			return ResponseEntity.notFound().build();
		else {
			service.delete(id);
			return ResponseEntity.ok().build();
		}
	}
}

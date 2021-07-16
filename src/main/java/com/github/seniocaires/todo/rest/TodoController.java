package com.github.seniocaires.todo.rest;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.github.seniocaires.todo.model.Todo;
import com.github.seniocaires.todo.repository.TodoRepository;

@RestController
@RequestMapping("/api/todos")
//@CrossOrigin(origins = {"http://localhost:4200", "https://seniocaires.github.io/"})
public class TodoController {

	@Autowired
	public TodoRepository repository;

	@GetMapping
	public List<Todo> getAll() {
		return repository.findAll();
	}

	@PostMapping
	public Todo save(@RequestBody Todo todo) {
		return repository.save(todo);
	}

	@GetMapping("{id}")
	public Todo getById(@PathVariable Long id) {
		return repository.findById(id) //
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
	}

	@DeleteMapping("{id}")
	public void delete(@PathVariable Long id) {
		repository.deleteById(id);
	}

	@PatchMapping("{id}/done")
	public Todo markAsDone(@PathVariable Long id) {
		return repository.findById(id).map(todo -> {
			todo.setDone(Boolean.TRUE);
			todo.setDoneDate(LocalDateTime.now());
			repository.save(todo);
			return todo;
		}).orElse(null);
	}
}

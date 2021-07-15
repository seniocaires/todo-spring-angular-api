package com.github.seniocaires.todo;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.github.seniocaires.todo.model.Todo;
import com.github.seniocaires.todo.repository.TodoRepository;

@SpringBootApplication
public class TodoSpringAngularApplication {

	@Autowired
	private TodoRepository todoRepository;

	@Bean
	public CommandLineRunner init() {
		return new CommandLineRunner() {

			@Override
			public void run(String... args) throws Exception {
				Todo todo = new Todo();
				todo.setDescription("Task 1");
				todo.setCreatedDate(LocalDateTime.now());
				todoRepository.save(todo);
			}
		};
	}

	public static void main(String[] args) {
		SpringApplication.run(TodoSpringAngularApplication.class, args);
	}

}

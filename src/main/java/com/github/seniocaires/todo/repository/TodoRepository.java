package com.github.seniocaires.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.github.seniocaires.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {

}

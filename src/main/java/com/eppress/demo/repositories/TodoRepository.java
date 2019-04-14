package com.eppress.demo.repositories;

import com.eppress.demo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;

@RestResource(exported = false)
public interface TodoRepository extends JpaRepository<Todo,Integer> {
}

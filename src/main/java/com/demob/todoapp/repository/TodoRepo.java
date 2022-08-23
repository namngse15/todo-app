package com.demob.todoapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demob.todoapp.entity.Todo;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Integer> {

}

package com.demob.todoapp.service;

import java.util.List;

import com.demob.todoapp.entity.Todo;

public interface TodoService {

    List<Todo> getTodoList();

    void addTodo(String title);

    void updateTodo(Integer id);

    void deleteTodo(Integer id);


    
}

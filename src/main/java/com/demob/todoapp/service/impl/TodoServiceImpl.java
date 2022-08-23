package com.demob.todoapp.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demob.todoapp.entity.Todo;
import com.demob.todoapp.repository.TodoRepo;
import com.demob.todoapp.service.TodoService;

@Service
public class TodoServiceImpl implements TodoService{
    public static int increase = 0;

    @Autowired
    TodoRepo todoRepo;

    public void addTodo(String title) {
        Todo todo = Todo.builder().title(title).completed(false).build();
        todoRepo.save(todo);
    }

    public List<Todo> getTodoList() {
        return todoRepo.findAll();
    }

    public void deleteTodo(Integer id) {
        todoRepo.deleteById(id);
    }

    public void updateTodo(Integer id) {
        Todo currTodo = todoRepo.findById(id).get();
        currTodo.setCompleted(!currTodo.isCompleted());
        todoRepo.save(currTodo);
    }
}

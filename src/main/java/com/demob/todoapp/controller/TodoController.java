package com.demob.todoapp.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.demob.todoapp.entity.Todo;
import com.demob.todoapp.service.TodoService;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @RequestMapping("/list-todo")
    public String listTodo(Model model) {
        List<Todo> list = todoService.getTodoList();
        model.addAttribute("list",list);
        return "todo/listTodo";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(HttpServletRequest request) {
        String title = request.getParameter("title");
        todoService.addTodo(title);
        return "redirect:/list-todo/";
    }

    @RequestMapping(value = "/complete-todo", method = RequestMethod.GET)
    public String updateTodo(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        todoService.updateTodo(id);
        return "redirect:/list-todo/";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(HttpServletRequest request) {
        Integer id = Integer.parseInt(request.getParameter("id"));
        todoService.deleteTodo(id);
        return "redirect:/list-todo/";
    }
}

package br.edu.ifpb.paulogui.api.controller;

import br.edu.ifpb.paulogui.api.model.ToDo;
import br.edu.ifpb.paulogui.api.service.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class ToDoController {
    @Autowired
    private ToDoService toDoService;

    @GetMapping("/tasks")
    public List<ToDo> getToDos() {
        return this.toDoService.getToDos();
    }

    @GetMapping("/{id}")
    public ToDo getToDoById(@PathVariable Long id) {
        return this.toDoService.toDoById(id);
    }

    @PostMapping
    public ToDo createTodo(@RequestBody ToDo todo) {
        return this.toDoService.postOrPutToDo(todo);
    }

    @PutMapping("/{id}")
    public ToDo editTodo(@RequestBody ToDo todo) {
        return this.toDoService.postOrPutToDo(todo);
    }

    @DeleteMapping("/{id}")
    public void deleteToDo(@PathVariable Long id){
        this.toDoService.deleteToDo(id);
    }
}

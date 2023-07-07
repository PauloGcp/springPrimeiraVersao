package br.edu.ifpb.paulogui.api.service;

import br.edu.ifpb.paulogui.api.model.ToDo;
import br.edu.ifpb.paulogui.api.repositories.ToDoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {
    @Autowired
    private ToDoRepository toDoRepository;

    public List<ToDo> getToDos(){
        return this.toDoRepository.findAll();
    }

    public ToDo toDoById(Long id){
        return this.toDoRepository.findById(id).orElse(null);
    }

    @Transactional
    public ToDo postOrPutToDo(ToDo todo){
        if(todo.getDescription().isEmpty()){
            throw new RuntimeException("É necessário haver uma descrição");
        }
        return this.toDoRepository.save(todo);
    }

    public void deleteToDo(Long id) {
        this.toDoRepository.deleteById(id);
    }
}

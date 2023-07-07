package br.edu.ifpb.paulogui.api.repositories;

import br.edu.ifpb.paulogui.api.model.ToDo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<ToDo, Long> {
}

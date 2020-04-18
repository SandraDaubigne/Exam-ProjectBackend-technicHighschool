package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //Using CrudRepository import methods to get all todos from the database
    //And returning a list of todos.
    public List<Todo> getAll() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos;
    }

    public Todo createTodo(String text) {
        Todo todo = new Todo();
        todo.setText(text);
        return todoRepository.save(todo);
    }

    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }
}

package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    //Create a todoes
    public Todo createTodo(String text) {
        Todo todo = new Todo();
        todo.setText(text);
        return todoRepository.save(todo);
    }

    //Delete a single todoes
    public void deleteTodo(int id) {
        todoRepository.deleteById(id);
    }

    //Update boolean on checked boxes or not
    public void updateActive(Todo todo) {
        todoRepository.save(todo);
    }

    //Show all active
    public List<Todo> getAllActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);

        return todos.stream().filter(todo -> todo.getActive() == true).collect(Collectors.toList());

    }

}

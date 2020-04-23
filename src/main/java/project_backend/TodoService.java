package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

//This is where the businesslogic flows,
//every method that manipulates the incomming and outcomming data from
//the database is here.

@Service
public class TodoService {

    @Autowired
    private TodoRepository todoRepository;

    //Get all todos from DB
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

    //Get all todoes witch boolean is true in object todoes variable active.
    public List<Todo> getAllActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos.stream().filter(todo -> todo.getActive() == true).collect(Collectors.toList());
    }

    //Get all todoes witch boolean is false in object todoes variable active.
    public List<Todo> getAllNotActive(){
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos::add);
        return todos.stream().filter(todo -> todo.getActive() == false).collect(Collectors.toList());
    }

    //Get all todoes witch boolean is true in object todoes variable active.
    //And then delete them one by one
    public void deleteActiveTodo() {
        List<Todo> todos = new ArrayList<>();
        todoRepository.findAll().forEach(todos :: add);
        todos.stream().filter(todo -> todo.getActive() == true).forEach(todo -> deleteTodo(todo.getId()));
    }

}

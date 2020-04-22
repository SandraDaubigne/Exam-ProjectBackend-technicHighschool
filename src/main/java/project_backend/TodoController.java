package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    //Startpage
    @GetMapping("/todo")
    public String startPage(Model model){
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    //Create a todoes
    @PostMapping("/create")
    public String saveTodo(@RequestParam("t1") String text){
        //den tar emot en parameter som skickas vidare till serviceklassen
        todoService.createTodo(text);
        return "redirect:todo";
    }

    //Check a todoes and change boolean in DB
    @RequestMapping(value = "/api",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@RequestBody Todo todo){
        todoService.updateActive(todo);
    }

    //Delete a todoes
    @PostMapping("/deleteitem")
    public String deleteItem(Model model, @RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:todo";
    }

    //BUTTONS:

    //See all todoes
    @PostMapping("/all")
    public String all(Model model){
        return "redirect:todo";
    }

    //Delete all checked (true) todoes
    @PostMapping("/deleteallcompleted")
    public String deleteAllCompleted(){
        todoService.deleteActiveTodo();
        return "redirect:todo";
    }
    
    //See all active (not checked todos/false)
    @PostMapping("/active")
    public String active(Model model){
        List<Todo> listTodo = todoService.getAllNotActive();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    //See all completed todos (checked/true)
    @PostMapping("/showcompleted")
    public String showCompleted(Model model){
        List<Todo> listTodo = todoService.getAllActive();
        model.addAttribute("todos", listTodo);
        return "todo";
    }



}

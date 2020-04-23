package project_backend;

//Controller class will handle all incomming request från the API and also return answers trought the model-classes
//back to the wiew.
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

    //I use this one method as a landingpage/startpage
    //and also to make clean code, hense i can redirect other methods
    //to this one. I also avoid multiple post-request by doing this
    //witch was a bug before i cleaned it up.
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
        //Takes in a name parameter from html with a value with the incomming text
        //that the user writes
        todoService.createTodo(text);
        return "redirect:todo";
    }

    //Check a todoes and change boolean in DB
    //This is a request sent from javascript fetch() and need to be taken care of
    //as a JSON object, Mediatype and Requestbidy makes it possible to convert
    //JSON object to a java object.
    @RequestMapping(value = "/api",method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public void updateItem(@RequestBody Todo todo){
        todoService.updateActive(todo);
    }

    //This twos methods redirect to the startpage method witch avoid
    //a lots of proble specified above.
    //Delete a todoes
    @PostMapping("/deleteitem")
    public String deleteItem(Model model, @RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect:todo";
    }

    //BUTTONS:

    //See all todoes
    @PostMapping("/all")
    public String all(){
        return "redirect:todo";
    }

    //Delete all checked (true) todoes
    @PostMapping("/deleteallcompleted")
    public String deleteAllCompleted(){
        todoService.deleteActiveTodo();
        return "redirect:todo";
    }

    //This methods cant hav redirect since they return
    //new things to the wiew thats needed.
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

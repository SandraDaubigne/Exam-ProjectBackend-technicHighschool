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


    //BUTTONS:

    //Delete a todoes
    @PostMapping("/deleteitem")
    public String deleteItem(Model model, @RequestParam int id){
        todoService.deleteTodo(id);
        model.addAttribute("message", "You did press the DELETE THIS ITEM button with id number " +id);
        return "redirect:todo";
    }

    //Toggla mellan boolean (icheckade eller inte)
    @PostMapping("/selectallboxes")
    public String secectAllBoxes(Model model){
        model.addAttribute("message", "You did press the SELECT ALL button");
        return "todo";
    }



    //See all todoes
    //samma som get all
    @PostMapping("/all")
    public String all(Model model){
        model.addAttribute("message", "You did press the ALL button");
        return "redirect:todo";
    }


    //Visa alla ocheckade
    @PostMapping("/active")
    public String active(Model model){

        return "todo";
    }

    //Show completed- Visa alla checkade
    @PostMapping("/showcompleted")
    public String showCompleted(Model model){
        List<Todo> listTodo = todoService.getAllActive();
        model.addAttribute("todos", listTodo);
        model.addAttribute("message", "You did press the ACTIVE button");
        return "todo";
    }

    //Delete all checked todoes - ta bort alla checkade
    @PostMapping("/deleteallcompleted")
    public String deleteAllCompleted(Model model){
        model.addAttribute("message", "You did press the DELETE ALL COMPLETED button");
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }








}

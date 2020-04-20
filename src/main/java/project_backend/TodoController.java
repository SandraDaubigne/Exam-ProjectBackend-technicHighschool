package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    //Förser wiew med info från backenden
    //Det den behöver ha för att visa det den ska visa.
    //Denna request anropas då du är på urlen eller uppdaterar
    @GetMapping("/")
    public String startPage(Model model){
        //Behöver listan för att kunna rendera alla todoer
        //Jag har tillgång till alla objekt från tds här pga att metoden getall skapar
        //och returnerar en lista av alla tds. Så därför kan jag använda tds attributer även
        //i Thymeleaf direkt.
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    //Är det som kommer in från Wiew
    //Backend behöver veta och kunna ta emot följande saker:
    @PostMapping("/")
    public String saveTodo(@RequestParam("t1") String text, Model model){
        //den tar emot en parameter som skickas vidare till serviceklassen
        todoService.createTodo(text);
        //Den tar emot ett model-objekt för att kunna
        // skicka listan med objekten till variablen todoes i templatens forloop
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    @PostMapping("/all")
    public String all(Model model){
        model.addAttribute("message", "You did press the ALL button");
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    @PostMapping("/active")
    public String active(Model model){
        model.addAttribute("message", "You did press the ACTIVE button");
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    @PostMapping("/showcompleted")
    public String showCompleted(Model model){
        model.addAttribute("message", "You did press the ALL COMPLETED button");
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    @PostMapping("/deleteallcompleted")
    public String deleteAllCompleted(Model model){
        model.addAttribute("message", "You did press the DELETE ALL COMPLETED button");
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

    //Delete single item
    //When you send i a path from the form ypu must have patvariables and not requestparameters these are for name="
    @PostMapping("/deleteitem")
    public String deleteItem(Model model, @RequestParam int id){
        todoService.deleteTodo(id);
        model.addAttribute("message", "You did press the DELETE THIS ITEM button with id number " +id);

        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }





    /*
    @PostMapping("/checked")
    public String showCheckbox(Model model) {
        boolean myBooleanVariable = false;
        model.addAttribute("myBooleanVariable", myBooleanVariable);
        return "sample-checkbox";
    }

    */





}

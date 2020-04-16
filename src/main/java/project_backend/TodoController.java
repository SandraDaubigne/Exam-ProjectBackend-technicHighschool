package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @PostMapping("/checked")
    public String showCheckbox(Model model) {
        boolean myBooleanVariable = false;
        model.addAttribute("myBooleanVariable", myBooleanVariable);
        return "sample-checkbox";
    }








    //Förser wiew med info från backenden
    //Det den behöver ha för att visa det den ska visa.
    //Denna request anropas då du är på urlen eller uppdaterar
    @GetMapping("/")
    public String listTodo(Model model){
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
    public String saveTodo(@RequestParam("t1")String text, Model model){

        //den tar emot en parameter som skickas vidare till serviceklassen
        todoService.createTodo(text);

        //Den tar emot ett model-objekt för att kunna
        // skicka listan med objekten till variablen todoes i templatens forloop
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);

        return "todo";

    }

}

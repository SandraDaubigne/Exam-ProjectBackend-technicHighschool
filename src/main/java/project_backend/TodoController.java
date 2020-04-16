package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    //Förser wiew med info från backenden
    //Det den behöver ha för att visa det den ska visa.
    //Denna request anropas då du är på urlen eller uppdaterar
    @GetMapping("/")
    public String listTodo(Model model){

        //Behöver objektet för att kunna förstå vad td betyder inne i template
        Todo todo = new Todo();
        model.addAttribute("todo", todo);

        //Behöver listan för att kunna rendera alla todoer
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

package project_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@Controller
public class TodoController {

    @Autowired
    TodoService todoService;

    @GetMapping("/he")
    public String listTodo(Model model){
        List<Todo> listTodo = todoService.getAll();
        model.addAttribute("todos", listTodo);
        return "todo";
    }

}

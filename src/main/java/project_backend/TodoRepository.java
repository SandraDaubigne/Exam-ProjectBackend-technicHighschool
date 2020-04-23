package project_backend;
//This interface is a part of the hibernate part of the code,
//since it comes with all that built-in methods that provide
//me with fuctions tha handles the request to the database
//The service-class is holding the methods.
import org.springframework.data.repository.CrudRepository;

public interface TodoRepository extends CrudRepository<Todo, Integer> {
}

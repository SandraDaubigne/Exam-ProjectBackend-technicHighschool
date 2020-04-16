package project_backend;

import org.springframework.data.repository.CrudRepository;

public interface TodoRespository extends CrudRepository<Todo, Integer> {
}

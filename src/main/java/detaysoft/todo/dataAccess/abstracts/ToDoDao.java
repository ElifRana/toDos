package detaysoft.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import detaysoft.todo.entities.concretes.ToDo;

public interface ToDoDao extends JpaRepository<ToDo, Integer>{

	ToDo findByWorkerId(int workerId);
}

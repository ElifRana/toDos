package detaysoft.todo.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import detaysoft.todo.entities.concretes.Executive;

public interface ExecutiveDao extends JpaRepository<Executive, Integer> {

}
